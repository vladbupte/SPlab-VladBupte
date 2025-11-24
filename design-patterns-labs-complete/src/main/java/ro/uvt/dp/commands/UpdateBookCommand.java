
package ro.uvt.dp.commands;

import ro.uvt.dp.models.Book;
import ro.uvt.dp.services.BooksService;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final Integer id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, Integer id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Optional<Book> execute() {
        if (booksService.getById(id).isPresent()) {
            Book updated = booksService.update(id, book);
            return Optional.of(updated);
        } else {
            return Optional.empty();
        }
    }
}
