package Laboratoare.commands;

import Laboratoare.model.Book;
import Laboratoare.service.BooksService;

public class GetBookByIdCommand implements Command<Book> {

    private final BooksService booksService;
    private final int id;

    public GetBookByIdCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Book execute() {
        return booksService.getBook(id);
    }
}
