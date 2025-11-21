package root.mh.cyb.booklibrarymanagement.services;

import root.mh.cyb.booklibrarymanagement.entities.Book;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public List<Book> getAllBooks();
    public Book getBookById(Long id);
    public Book updateBook(Long id,Book book);
    public void deleteBookById(Long id);
    public List<Book> findBooksByAuthor(String authorName);
    public List<Book> findBookByGenre(String genre);
    public List<Book> findBookByPublication(String publication);
}
