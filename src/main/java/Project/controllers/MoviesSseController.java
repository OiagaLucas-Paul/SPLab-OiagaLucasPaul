package Project.controllers;

import Project.observer.AllMoviesSubject;
import Project.observer.SseObserver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class MoviesSseController {

    private final AllMoviesSubject subject;

    public MoviesSseController(AllMoviesSubject subject) {
        this.subject = subject;
    }

    @GetMapping(value = "/movies-sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream() {
        SseEmitter emitter = new SseEmitter(0L); // no timeout
        SseObserver observer = new SseObserver(emitter);

        subject.attach(observer);

        emitter.onCompletion(() -> subject.detach(observer));
        emitter.onTimeout(() -> subject.detach(observer));
        emitter.onError(e -> subject.detach(observer));

        return emitter;
    }
}
