package Project.controllers;

import Project.commands.*;
import Project.dto.*;
import Project.executor.AsynchronousCommandExecutor;
import Project.executor.AsyncRequestStore;
import Project.executor.SynchronousCommandExecutor;
import Project.model.Movie;
import Project.service.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MoviesService moviesService;
    private final SynchronousCommandExecutor syncExecutor;
    private final AsynchronousCommandExecutor asyncExecutor;
    private final AsyncRequestStore asyncRequestStore;

    public MoviesController(MoviesService moviesService,
                            SynchronousCommandExecutor syncExecutor,
                            AsynchronousCommandExecutor asyncExecutor,
                            AsyncRequestStore asyncRequestStore) {
        this.moviesService = moviesService;
        this.syncExecutor = syncExecutor;
        this.asyncExecutor = asyncExecutor;
        this.asyncRequestStore = asyncRequestStore;
    }

    // Sync GETs
    @GetMapping
    public List<Movie> getAll() {
        return syncExecutor.execute(new GetAllMoviesCommand(moviesService));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable int id) {
        Movie movie = syncExecutor.execute(new GetMovieByIdCommand(moviesService, id));
        return movie == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(movie);
    }

    // Async POST
    @PostMapping
    public ResponseEntity<AsyncRequestAcceptedResponse> create(@RequestBody MovieCreateRequest req) {
        String requestId = asyncExecutor.submit(new CreateMovieCommand(moviesService, req));
        return ResponseEntity.accepted().body(new AsyncRequestAcceptedResponse(requestId));
    }

    // Sync PUT (poți face și async dacă vrei)
    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable int id, @RequestBody MovieUpdateRequest req) {
        Movie updated = syncExecutor.execute(new UpdateMovieCommand(moviesService, id, req));
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    // Async DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<AsyncRequestAcceptedResponse> delete(@PathVariable int id) {
        String requestId = asyncExecutor.submit(new DeleteMovieCommand(moviesService, id));
        return ResponseEntity.accepted().body(new AsyncRequestAcceptedResponse(requestId));
    }

    // Poll async status
    @GetMapping("/requests/{requestId}")
    public ResponseEntity<AsyncCommandStatusResponse> getStatus(@PathVariable String requestId) {
        AsyncCommandStatusResponse status = asyncRequestStore.get(requestId);
        return status == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(status);
    }
}
