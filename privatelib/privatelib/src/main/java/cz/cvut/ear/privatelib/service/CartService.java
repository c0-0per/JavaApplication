package cz.cvut.ear.privatelib.service;

import cz.cvut.ear.privatelib.dao.CartDao;
import cz.cvut.ear.privatelib.dao.TitleDao;
import cz.cvut.ear.privatelib.dao.UserDao;
import cz.cvut.ear.privatelib.dto.BookDto;
import cz.cvut.ear.privatelib.model.Book;
import cz.cvut.ear.privatelib.model.Cart;
import cz.cvut.ear.privatelib.model.Title;
import cz.cvut.ear.privatelib.model.User;
import cz.cvut.ear.privatelib.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class CartService {
    private final CartDao dao;

    private final TitleDao titleDao;

    private final UserDao userDao;

    private final BookService bookService;

    public CartService(CartDao dao, TitleDao titleDao, UserDao userDao, BookService bookService) {
        this.dao = dao;
        this.titleDao = titleDao;
        this.userDao = userDao;
        this.bookService = bookService;
    }

    @Transactional(readOnly = true)
    public Cart findByOwner(User owner) {
        return dao.findByOwner(owner);
    }

    /**
     * Adds a certain book to cart
     * @param book Book to add to reservation cart
     */
    @Transactional
    public void addBook(BookDto book) {
        String loginName = Utils.getCurrentUserLogin().get();

        Objects.requireNonNull(book);
        User user = userDao.findByUsername(loginName);

        Book book1 = bookService.find(book.getId());
        if(book1 == null) {
            throw new RuntimeException("NO book in library");
        }
        if(book1.getReserved() == true || book1.getLoaned() == true) {
            throw new RuntimeException("Book is reserved or loaned");
        }
        Cart cart = new Cart();
        cart.setOwner(user);

        cart.setBook(book1);
        Cart existingCart = dao.findByOwnerAndBook(user,book1);
        if (existingCart != null) {
            throw new RuntimeException("User already has a book in the cart");
        }
        dao.persist(cart);

        final Title title = book1.getTitle();
        if(title.getNumberOfFreeItems()!= null && title.getNumberOfFreeItems() < 1) {
            throw new RuntimeException();
        }
        title.setNumberOfFreeItems(title.getNumberOfFreeItems() - 1);
        titleDao.update(title);
        dao.update(cart);
    }

    /**
     * Remove a certain book from cart
     * @param book BookDto to remove from reservation cart
     */
    @Transactional
    public void removeBook( BookDto book) {
        String loginName = Utils.getCurrentUserLogin().get();
        Objects.requireNonNull(book);
        User user = userDao.findByUsername(loginName);

        Book book1 = bookService.find(book.getId());
        Cart cart = dao.findByOwnerAndBook(user, book1);
        dao.remove(cart);

        final Title title = book1.getTitle();
        title.setNumberOfFreeItems(title.getNumberOfFreeItems() + 1);
        titleDao.update(title);
        //**************************

    }
}
