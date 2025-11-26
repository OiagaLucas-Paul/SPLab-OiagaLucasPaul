package Laboratoare.commands;

import Laboratoare.service.BooksService;

public class DeleteBookCommand implements Command<Void> {

    private final BooksService booksService;
    private final int id;

    public DeleteBookCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Void execute() {
        booksService.deleteBook(id);
        return null;
    }
}
