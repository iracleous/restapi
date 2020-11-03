package gr.athtech.restapi.controller;


import gr.athtech.restapi.model.Book;
import gr.athtech.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookShopRestController {


    private BookService bookService ;

    @Autowired
    public BookShopRestController(BookService bookService) {
        this.bookService = bookService;
    }

    // http://localhost:8080/book/{id}  GET
    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {

        Book book =bookService.getById(id);
        if (book ==null)
        {
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

        }
        else{
            return new ResponseEntity<>(book, HttpStatus.OK );
        }


    }

    @GetMapping("books")
    public List<Book> getAllBook() {

        return bookService.getAllBooks();
    }

    @PostMapping("book")
    public Book addBook(@RequestBody Book book) {

        return bookService.addBook(book);
    }


    @DeleteMapping("book/{id}")
    public boolean deleteBook(@PathVariable int id) {

        return bookService.delete(id);
    }


    @PutMapping("book/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {

        return bookService.update(book, id);
    }

}