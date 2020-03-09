package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.model.Book;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    BookDaoImpl() {
    }

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }
}
