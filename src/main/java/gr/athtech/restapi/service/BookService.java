package gr.athtech.restapi.service;

import gr.athtech.restapi.model.Book;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    Book getById(int idtle);
    List<Book> getAllBooks();
    Book update(Book book, int id);
    boolean delete(int id);

    Book assignAuthor(int authorId,  Book book);

}
