package gr.athtech.restapi.service.impl;


import gr.athtech.restapi.dto.BookDto;
import gr.athtech.restapi.exception.ValidationException;
import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Book;
import gr.athtech.restapi.repository.AuthorRepository;
import gr.athtech.restapi.repository.BookRepository;
import gr.athtech.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class BookDbServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BookDto addBook(BookDto bookDto) throws ValidationException {
        //validation
        if (bookDto == null) throw new ValidationException("Null book was inserted");
        Book book = BookDto.getBook(bookDto);
        return BookDto.getBookDto(bookRepository.save(book));
    }

    @Override
    public BookDto getById(int id) {
        Optional<Book> optionBook = bookRepository.findById(id);
        if (optionBook.isEmpty()) return null;

        return BookDto.getBookDto(optionBook.get());
    }

    @Override
    public List<BookDto> getAllBooks() {

        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();

        books.forEach(book -> bookDtos.add(BookDto.getBookDto(book)));
        return bookDtos;
    }

    @Override
    public BookDto update(BookDto bookDto, int id) {
        Book book = BookDto.getBook(bookDto);
        Book retBook = bookRepository.save(book);
        return BookDto.getBookDto(retBook);
    }

    @Override
    public boolean delete(int id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isEmpty()) return false;
        bookRepository.delete(bookOpt.get());
        return true;
    }


    @Override
    public BookDto assignAuthor(int authorId, BookDto dookDto) {
        if (dookDto ==null) return null;
        Optional<Book> bookOpt = bookRepository.findById(dookDto.getId());
        if(bookOpt.isEmpty())return null;
        Book book= bookOpt.get();
        Author authorInDb = authorRepository.findById(authorId).get();

        book.setAuthor(authorInDb);
        return BookDto.getBookDto(bookRepository.save(book));


    }

}
