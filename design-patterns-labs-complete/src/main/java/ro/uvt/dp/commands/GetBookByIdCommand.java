
package ro.uvt.dp.commands;

import ro.uvt.dp.models.Book;
import ro.uvt.dp.services.BooksService;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final Integer id;

    public GetBookByIdCommand(BooksService booksService, Integer id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.getById(id);
    }
}
