package Laboratoare.commands;

import Laboratoare.service.BooksService;

public class GetBookByIdCommand implements Command<String> {
    private final BooksService booksService;
    private final int id;

    public GetBookByIdCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public String execute() {
        return booksService.getBook(id);
    }
}
