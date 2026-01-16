package Project.observer;

import Project.model.Movie;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver implements Observer {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Movie movie) {
        try {
            emitter.send(SseEmitter.event()
                    .name("movie-created")
                    .data(movie));
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }

    public SseEmitter getEmitter() {
        return emitter;
    }
}
