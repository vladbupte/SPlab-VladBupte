
package ro.uvt.dp.commands;

import ro.uvt.dp.models.Book;
import ro.uvt.dp.services.BooksService;

public class CreateBookCommand implements Command<Book> {

    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        return booksService.create(book);
    }
}
