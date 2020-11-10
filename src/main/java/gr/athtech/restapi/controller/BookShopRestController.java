package gr.athtech.restapi.controller;


import gr.athtech.restapi.dto.AuthorDto;
import gr.athtech.restapi.dto.BookDto;
import gr.athtech.restapi.exception.ValidationException;
import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Book;
import gr.athtech.restapi.service.AuthorService;
import gr.athtech.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookShopRestController {

    @Autowired
    private BookService bookService ;
    @Autowired
    private AuthorService authorService;




    // http://localhost:8080/book/{id}  GET
    @GetMapping("book/{id}")
    public BookDto getBook(@PathVariable int id) {

        BookDto book =bookService.getById(id);
        if (book ==null)
        {
           return null;

        }
        else{
            return book;
        }


    }

    @GetMapping("books")
    public List<BookDto> getAllBook() {

        return bookService.getAllBooks();
    }

    @PostMapping("book")
    public BookDto addBook(@RequestBody BookDto book) throws ValidationException {

        return bookService.addBook(book);
    }


    @DeleteMapping("book/{id}")
    public boolean deleteBook(@PathVariable int id) {

        return bookService.delete(id);
    }


    @PutMapping("book/{id}")
    public BookDto updateBook(@PathVariable int id, @RequestBody BookDto book) {

        return bookService.update(book, id);
    }


    //////////////////////////////////////////////////////////////
    @GetMapping("authors")
    public List<AuthorDto> getAllAuthors() {

        return authorService.getAllAuthors();
    }

    @PostMapping("author")
    public AuthorDto addAuthor(@RequestBody AuthorDto author) {

        return authorService.addAuthor(author);
    }


    @GetMapping("author/{id}")
    public AuthorDto getAuthor(@PathVariable int id) {
        return authorService.getById(id);
    }

    @PutMapping("author/{authorId}/addbook")
    public BookDto addBookToAutor(@PathVariable int authorId, @RequestBody BookDto book) {
        return bookService.assignAuthor(authorId, book);
    }

}