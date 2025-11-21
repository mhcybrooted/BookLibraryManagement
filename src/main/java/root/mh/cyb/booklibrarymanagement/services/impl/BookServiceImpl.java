package root.mh.cyb.booklibrarymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import root.mh.cyb.booklibrarymanagement.entities.Book;
import root.mh.cyb.booklibrarymanagement.repositories.BookRepository;
import root.mh.cyb.booklibrarymanagement.services.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Book previous = repository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        previous.setTitle((updatedBook.getTitle() == null) ? previous.getTitle() : updatedBook.getTitle());
        previous.setAuthor((updatedBook.getAuthor() == null) ? previous.getAuthor() : updatedBook.getAuthor());
        previous.setGenre((updatedBook.getGenre() == null) ? previous.getGenre() : updatedBook.getGenre());
        previous.setPublication((updatedBook.getPublication() == null) ? previous.getPublication() : updatedBook.getPublication());
        previous.setAvailableCopies((updatedBook.getAvailableCopies()) == null ? previous.getAvailableCopies() : updatedBook.getAvailableCopies());
        previous.setPublicationYear((updatedBook.getPublicationYear()) == null ? previous.getPublicationYear() : updatedBook.getPublicationYear());
        return repository.save(previous);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        repository.delete(book);
    }

    @Override
    public List<Book> findBooksByAuthor(String authorName) {
        return repository.findBooksByAuthor(authorName);
    }

    @Override
    public List<Book> findBookByGenre(String genre) {
        return repository.findBooksByGenre(genre);
    }

    @Override
    public List<Book> findBookByPublication(String publication) {
        return repository.findBooksByPublication(publication);
    }


}
