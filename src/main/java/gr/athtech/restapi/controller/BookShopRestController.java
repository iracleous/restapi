package gr.athtech.restapi.controller;


import gr.athtech.restapi.model.Book;
import gr.athtech.restapi.service.BookService;
import gr.athtech.restapi.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookShopRestController {

    private BookService bookService = new BookServiceImpl();

    // http://localhost:8080/book/{id}  GET
    @GetMapping("book/{id}")
    public Book getBook(@PathVariable int id) {

        return bookService.getById(id);
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