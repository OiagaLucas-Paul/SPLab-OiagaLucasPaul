package Laboratoare.controllers;

import Laboratoare.async.AsyncCommandResult;
import Laboratoare.async.AsyncCommandStore;
import Laboratoare.async.AsyncStatus;
import Laboratoare.async.AsynchronousCommandExecutor;
import Laboratoare.commands.*;
import Laboratoare.dto.AsyncCommandStatusResponse;
import Laboratoare.dto.AsyncRequestAcceptedResponse;
import Laboratoare.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final SynchronousCommandExecutor synchronousCommandExecutor;
    private final AsynchronousCommandExecutor asynchronousCommandExecutor;
    private final AsyncCommandStore asyncCommandStore;

    public BooksController(BooksService booksService,
                           SynchronousCommandExecutor synchronousCommandExecutor,
                           AsynchronousCommandExecutor asynchronousCommandExecutor,
                           AsyncCommandStore asyncCommandStore) {
        this.booksService = booksService;
        this.synchronousCommandExecutor = synchronousCommandExecutor;
        this.asynchronousCommandExecutor = asynchronousCommandExecutor;
        this.asyncCommandStore = asyncCommandStore;
    }

    // --------- SYNCHRONOUS (GETs) ---------

    @GetMapping
    public List<String> getAllBooks() {
        return synchronousCommandExecutor.execute(new GetAllBooksCommand(booksService));
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable int id) {
        return synchronousCommandExecutor.execute(new GetBookByIdCommand(booksService, id));
    }

    // --------- ASYNCHRONOUS (POST / PUT / DELETE) ---------

    @PostMapping
    public ResponseEntity<AsyncRequestAcceptedResponse> createBook(@RequestBody String book) {
        UUID requestId = asynchronousCommandExecutor.submit(
                new CreateBookCommand(booksService, book)
        );

        AsyncRequestAcceptedResponse body = new AsyncRequestAcceptedResponse(requestId);

        return ResponseEntity
                .accepted()
                .location(URI.create("/books/requests/" + requestId))
                .body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsyncRequestAcceptedResponse> updateBook(@PathVariable int id,
                                                                   @RequestBody String newBook) {
        UUID requestId = asynchronousCommandExecutor.submit(
                new UpdateBookCommand(booksService, id, newBook)
        );

        AsyncRequestAcceptedResponse body = new AsyncRequestAcceptedResponse(requestId);

        return ResponseEntity
                .accepted()
                .location(URI.create("/books/requests/" + requestId))
                .body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AsyncRequestAcceptedResponse> deleteBook(@PathVariable int id) {
        UUID requestId = asynchronousCommandExecutor.submit(
                new DeleteBookCommand(booksService, id)
        );

        AsyncRequestAcceptedResponse body = new AsyncRequestAcceptedResponse(requestId);

        return ResponseEntity
                .accepted()
                .location(URI.create("/books/requests/" + requestId))
                .body(body);
    }

    // --------- POLLING STATUS FOR ASYNC REQUESTS ---------

    @GetMapping("/requests/{requestId}")
    public ResponseEntity<AsyncCommandStatusResponse> getAsyncStatus(@PathVariable UUID requestId) {
        AsyncCommandResult<?> result = asyncCommandStore.get(requestId);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        AsyncCommandStatusResponse response = new AsyncCommandStatusResponse(
                result.getId(),
                result.getStatus(),
                result.getResult(),
                result.getError() != null ? result.getError().getMessage() : null
        );

        return ResponseEntity.ok(response);
    }
}
