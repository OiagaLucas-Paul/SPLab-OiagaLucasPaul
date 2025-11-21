package Laboratoare.commands;

import Laboratoare.service.BooksService;
import java.util.List;

public class GetAllBooksCommand implements Command<List<String>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<String> execute() {
        return booksService.getAllBooks();
    }
}

