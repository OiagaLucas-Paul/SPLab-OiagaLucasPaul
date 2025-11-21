package Laboratoare.commands;

import Laboratoare.service.BooksService;

public class CreateBookCommand implements Command<Void> {
    private final BooksService booksService;
    private final String book;

    public CreateBookCommand(BooksService booksService, String book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Void execute() {
        booksService.addBook(book);
        return null;
    }
}
