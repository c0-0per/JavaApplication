package cz.cvut.ear.privatelib.rest;

import cz.cvut.ear.privatelib.dto.BookDto;
import cz.cvut.ear.privatelib.model.Book;
import cz.cvut.ear.privatelib.model.Cart;
import cz.cvut.ear.privatelib.service.CartService;
import cz.cvut.ear.privatelib.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }



    /**
     * Adds a certain book to cart
     * @param bookToAdd
     */

    @PostMapping(value = "/book_items", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookDto bookToAdd) {
        cartService.addBook(bookToAdd);
    }


    //пофиксить ошибку позже
    /**
     * Remove a certain book from cart
     * @param book
     */
    @PutMapping(value = "/book_items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeBook(@RequestBody BookDto book) {
        cartService.removeBook( book);
    }


}
