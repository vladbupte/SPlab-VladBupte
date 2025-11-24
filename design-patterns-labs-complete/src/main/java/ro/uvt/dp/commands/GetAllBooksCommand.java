
package ro.uvt.dp.commands;

import ro.uvt.dp.models.Book;
import ro.uvt.dp.services.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {

    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAll();
    }
}
