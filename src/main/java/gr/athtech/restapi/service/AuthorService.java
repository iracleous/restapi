package gr.athtech.restapi.service;

import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Book;

import java.util.List;

public interface AuthorService {


    Author addAuthor(Author author);
    Author getById(int id);
    List<Author> getAllAuthors();
    Author update(Author author, int id);
    boolean delete(int id);

}
