
package ro.uvt.dp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.dp.commands.*;
import ro.uvt.dp.models.Book;
import ro.uvt.dp.services.BooksService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Book> getAll() throws Exception {
        return CommandExecutor.run(new GetAllBooksCommand(booksService));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) throws Exception {
        Optional<Book> opt = CommandExecutor.run(new GetBookByIdCommand(booksService, id));
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book b) throws Exception {
        Book created = CommandExecutor.run(new CreateBookCommand(booksService, b));
        return ResponseEntity.created(URI.create("/books/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book b) throws Exception {
        Optional<Book> updated = CommandExecutor.run(new UpdateBookCommand(booksService, id, b));
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        Optional<Void> res = CommandExecutor.run(new DeleteBookCommand(booksService, id));
        if (res.isPresent()) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}
