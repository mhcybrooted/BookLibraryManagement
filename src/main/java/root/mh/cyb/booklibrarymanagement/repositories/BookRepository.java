package root.mh.cyb.booklibrarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import root.mh.cyb.booklibrarymanagement.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    public List<Book> findBooksByAuthor(String authorName);

    List<Book> findBooksByGenre(String genre);

    List<Book> findBooksByPublication(String publication);
}
