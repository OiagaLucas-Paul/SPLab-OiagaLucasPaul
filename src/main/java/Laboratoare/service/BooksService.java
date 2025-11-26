package Laboratoare.service;

import Laboratoare.model.Book;
import Laboratoare.observer.AllBooksSubject;
import Laboratoare.persistence.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final CrudRepository<Book, Integer> booksRepository;
    private final AllBooksSubject allBooksSubject;

    public BooksService(CrudRepository<Book, Integer> booksRepository,
                        AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.allBooksSubject = allBooksSubject;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBook(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book addBook(String title) {
        Book book = new Book(title);
        Book saved = booksRepository.save(book);

        allBooksSubject.add(saved);

        return saved;
    }

    public Book updateBook(int id, String newTitle) {
        return booksRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(newTitle);
                    Book saved = booksRepository.save(existing);
                    allBooksSubject.add(saved);
                    return saved;
                })
                .orElse(null);
    }

    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }
}
