
package ro.uvt.dp.commands;

import ro.uvt.dp.services.BooksService;

import java.util.Optional;

public class DeleteBookCommand implements Command<Optional<Void>> {

    private final BooksService booksService;
    private final Integer id;

    public DeleteBookCommand(BooksService booksService, Integer id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Optional<Void> execute() {
        if (booksService.getById(id).isPresent()) {
            booksService.delete(id);
            return Optional.of(null);
        } else {
            return Optional.empty();
        }
    }
}
