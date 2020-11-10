package gr.athtech.restapi.dto;

import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Book;
import lombok.Data;

import java.util.ArrayList;

@Data
public class BookDto {
    private int id;

    private String title;
    private double price;

    private String author;


    public static Book getBook(BookDto bookDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());

        return book;
    }


    public static BookDto  getBookDto( Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setPrice(book.getPrice());
        if (book.getAuthor()!=null)
        {
            bookDto.author =  book.getAuthor().getLastName();
        }

        return bookDto;
    }





}
