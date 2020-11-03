package gr.athtech.restapi.service.impl;


import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Book;
import gr.athtech.restapi.repository.AuthorRepository;
import gr.athtech.restapi.repository.BookRepository;
import gr.athtech.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDbServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book addBook(Book book) {
       if (book==null) return null;
        return  bookRepository.save(book);
    }

    @Override
    public Book getById(int id) {
        Optional<Book> optionBook = bookRepository.findById(id);
        return optionBook.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Book book, int id) {
        return bookRepository.save(book);
    }

    @Override
    public boolean delete(int id) {
        Book book = getById(  id);
        if (book==null)   return false;
        bookRepository.delete(book);
      return true;
    }


    @Override
    public Book assignAuthor(int authorId,  Book book){
        Book bookInDb = getById(  book.getId());
        Author authorInDb = authorRepository.findById(authorId).get();

        bookInDb.setAuthor(authorInDb);
       return bookRepository.save(bookInDb);


    }

}
