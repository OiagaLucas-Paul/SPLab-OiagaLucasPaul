package Laboratoare.commands;

import Laboratoare.model.Book;
import Laboratoare.service.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {

    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAllBooks();
    }
}
