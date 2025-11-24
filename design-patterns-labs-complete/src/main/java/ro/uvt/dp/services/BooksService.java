
package ro.uvt.dp.services;

import org.springframework.stereotype.Service;
import ro.uvt.dp.models.Book;
import ro.uvt.dp.persistence.CrudRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final CrudRepository<Book, Integer> booksRepository;
    private final AllBooksSubject subject;

    public BooksService(CrudRepository<Book, Integer> booksRepository, AllBooksSubject subject) {
        this.booksRepository = booksRepository;
        this.subject = subject;
    }

    public List<Book> getAll() { return booksRepository.findAll(); }
    public Optional<Book> getById(Integer id) { return booksRepository.findById(id); }
    public Book create(Book b) {
        Book saved = booksRepository.save(b);
        subject.add(saved);
        return saved;
    }
    public Book update(Integer id, Book b) {
        b.setTitle(b.getTitle());
        b = booksRepository.save(b);
        return b;
    }
    public void delete(Integer id) { booksRepository.deleteById(id); }
}
