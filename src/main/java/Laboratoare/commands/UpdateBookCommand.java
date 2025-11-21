package Laboratoare.commands;

import Laboratoare.service.BooksService;

public class UpdateBookCommand implements Command<Void> {
    private final BooksService booksService;
    private final int id;
    private final String newBook;

    public UpdateBookCommand(BooksService booksService, int id, String newBook) {
        this.booksService = booksService;
        this.id = id;
        this.newBook = newBook;
    }

    @Override
    public Void execute() {
        booksService.updateBook(id, newBook);
        return null;
    }
}
