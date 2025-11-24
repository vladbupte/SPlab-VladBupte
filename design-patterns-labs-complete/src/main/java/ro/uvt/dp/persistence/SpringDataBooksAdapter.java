
package ro.uvt.dp.persistence;

import org.springframework.stereotype.Component;
import ro.uvt.dp.models.Book;

import java.util.List;
import java.util.Optional;

@Component
public class SpringDataBooksAdapter implements CrudRepository<Book, Integer> {

    private final BooksRepository delegate;

    public SpringDataBooksAdapter(BooksRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<Book> findAll() { return delegate.findAll(); }

    @Override
    public Optional<Book> findById(Integer id) { return delegate.findById(id); }

    @Override
    public Book save(Book entity) { return delegate.save(entity); }

    @Override
    public void deleteById(Integer id) { delegate.deleteById(id); }
}
