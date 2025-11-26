package Laboratoare.service;

import Laboratoare.model.Book;
import Laboratoare.persistence.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final CrudRepository<Book, Integer> booksRepository;

    public BooksService(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBook(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book addBook(String title) {
        Book book = new Book(title);
        return booksRepository.save(book);
    }

    public Book updateBook(int id, String newTitle) {
        return booksRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(newTitle);
                    return booksRepository.save(existing);
                })
                .orElse(null);
    }

    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }
}
