package Laboratoare.controllers;

import Laboratoare.observer.AllBooksSubject;
import Laboratoare.observer.SseObserver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping(path = "/books-sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        final SseObserver observer = new SseObserver(emitter);

        allBooksSubject.attach(observer);

        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> {
            allBooksSubject.detach(observer);
            emitter.complete();
        });
        emitter.onError(e -> allBooksSubject.detach(observer));

        return emitter;
    }
}
