
package ro.uvt.dp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.dp.services.AllBooksSubject;

@RestController
public class BooksSseController {

    private final AllBooksSubject subject;

    public BooksSseController(AllBooksSubject subject) { this.subject = subject; }

    @GetMapping("/books-sse")
    public SseEmitter stream() {
        return subject.attach();
    }
}
