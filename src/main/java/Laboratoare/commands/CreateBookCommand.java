package Laboratoare.commands;

import Laboratoare.model.Book;
import Laboratoare.service.BooksService;

public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final String title;

    public CreateBookCommand(BooksService booksService, String title) {
        this.booksService = booksService;
        this.title = title;
    }

    @Override
    public Book execute() {
        return booksService.addBook(title);
    }
}
