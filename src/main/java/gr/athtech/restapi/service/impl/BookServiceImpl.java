package gr.athtech.restapi.service.impl;

import gr.athtech.restapi.model.Book;
import gr.athtech.restapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



public class BookServiceImpl implements BookService {

   private static List<Book> books = new ArrayList<>();



    @Override
    public Book addBook(Book book) {
        int id = books.size();
        book.setId(id);
        books.add(book);
        return books.get(books.size()-1);
    }

    @Override
    public Book getById(int id) {

        if (id<=0 || id>books.size()) return null;
        return books.get(id-1);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book update(Book book, int id) {

        Book bookInList = books.get(id-1);
        bookInList.setAuthor(book.getAuthor());
        bookInList.setTitle(book.getTitle());
        bookInList.setPrice(book.getPrice());
        return bookInList;
    }

    @Override
    public boolean delete(int id) {
        if (id> books.size() ||  id<=0) return false;
         books.remove(id -1);
        return true;
    }

    @Override
    public Book assignAuthor(int authorId, Book book) {
        return null;
    }
}
