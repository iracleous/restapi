package gr.athtech.restapi.service;

import gr.athtech.restapi.dto.BookDto;
import gr.athtech.restapi.exception.ValidationException;
import gr.athtech.restapi.model.Book;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {

    BookDto addBook(BookDto bookDto) throws ValidationException;
    BookDto getById(int id);
    List<BookDto> getAllBooks();
    BookDto update(BookDto bookDto, int id);
    boolean delete(int id);

    BookDto assignAuthor(int authorId,  BookDto bookDto);

}
