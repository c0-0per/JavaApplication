package cz.cvut.ear.privatelib.dao;

import cz.cvut.ear.privatelib.model.Book;
import cz.cvut.ear.privatelib.model.Cart;
import cz.cvut.ear.privatelib.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDao extends AbstractDao<Cart>{

    public CartDao() {
        super(Cart.class);
    }

    public Cart findByOwner(User owner) {
        try {
            return manager.createQuery("SELECT c FROM Cart c WHERE c.owner = :owner", Cart.class)
                    .setParameter("owner", owner)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Cart findByOwnerAndBook(User owner, Book book) {
        try {
            return manager.createQuery("SELECT c FROM Cart c WHERE c.owner = :owner AND c.book = :book", Cart.class)
                    .setParameter("owner", owner)
                    .setParameter("book", book)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Cart> findAllCartsByOwner(User owner) {
        try {
            return manager.createQuery("SELECT c FROM Cart c WHERE c.owner = :owner", Cart.class)
                    .setParameter("owner", owner)
                    .getResultList();
        } catch (NoResultException e) {
            // No carts found for the user
            return new ArrayList<>();
        }
    }

}
