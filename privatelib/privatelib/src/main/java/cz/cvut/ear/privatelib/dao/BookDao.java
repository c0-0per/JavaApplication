package cz.cvut.ear.privatelib.dao;

import cz.cvut.ear.privatelib.model.Book;
import cz.cvut.ear.privatelib.model.Title;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Repository
public class BookDao extends AbstractDao<Book> {

    @PersistenceContext
    private EntityManager manager;

    protected BookDao() {
        super(Book.class);
    }

    public Book find(Integer id) {
        Objects.requireNonNull(id);
        return manager.find(Book.class, id);
    }



}
