package Laboratoare.controllers;

import Laboratoare.commands.*;
import Laboratoare.service.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<String> getAllBooks() {
        return new GetAllBooksCommand(booksService).execute();
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable int id) {
        return new GetBookByIdCommand(booksService, id).execute();
    }

    @PostMapping
    public void createBook(@RequestBody String book) {
        new CreateBookCommand(booksService, book).execute();
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody String newBook) {
        new UpdateBookCommand(booksService, id, newBook).execute();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        new DeleteBookCommand(booksService, id).execute();
    }
}
