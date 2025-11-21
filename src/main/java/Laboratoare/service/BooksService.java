package Laboratoare.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class BooksService {

    private final List<String> books = new ArrayList<>();

    public BooksService() {
        books.add("Dummy Book 1");
        books.add("Dummy Book 2");
    }

    public List<String> getAllBooks() {
        return books;
    }

    public String getBook(int id) {
        if (id >= 0 && id < books.size()) return books.get(id);
        return null;
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void updateBook(int id, String newBook) {
        if (id >= 0 && id < books.size()) books.set(id, newBook);
    }

    public void deleteBook(int id) {
        if (id >= 0 && id < books.size()) books.remove(id);
    }
}
