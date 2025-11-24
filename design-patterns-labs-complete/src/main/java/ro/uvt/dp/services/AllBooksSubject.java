
package ro.uvt.dp.services;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.dp.models.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {

    private final List<SseEmitter> emitters = new ArrayList<>();

    public SseEmitter attach() {
        SseEmitter emitter = new SseEmitter(0L);
        synchronized (emitters) { emitters.add(emitter); }
        emitter.onCompletion(() -> { synchronized (emitters) { emitters.remove(emitter); } });
        emitter.onTimeout(() -> { synchronized (emitters) { emitters.remove(emitter); } });
        return emitter;
    }

    public void add(Book book) {
        List<SseEmitter> dead = new ArrayList<>();
        synchronized (emitters) {
            for (SseEmitter e : emitters) {
                try {
                    e.send(book);
                } catch (Exception ex) {
                    dead.add(e);
                }
            }
            emitters.removeAll(dead);
        }
    }
}
