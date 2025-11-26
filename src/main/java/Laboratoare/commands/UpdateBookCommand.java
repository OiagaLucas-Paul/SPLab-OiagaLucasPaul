package Laboratoare.commands;

import Laboratoare.model.Book;
import Laboratoare.service.BooksService;

public class UpdateBookCommand implements Command<Book> {

    private final BooksService booksService;
    private final int id;
    private final String newTitle;

    public UpdateBookCommand(BooksService booksService, int id, String newTitle) {
        this.booksService = booksService;
        this.id = id;
        this.newTitle = newTitle;
    }

    @Override
    public Book execute() {
        return booksService.updateBook(id, newTitle);
    }
}
