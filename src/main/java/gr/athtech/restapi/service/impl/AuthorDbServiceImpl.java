package gr.athtech.restapi.service.impl;

import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.repository.AuthorRepository;
import gr.athtech.restapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorDbServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        if (author==null) return null;
        return  authorRepository.save(author);
    }

    @Override
    public Author getById(int id) {
        Optional<Author> optionAuthor = authorRepository.findById(id);
        return optionAuthor.orElse(null);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author update(Author author, int id) {
        return authorRepository.save(author);
    }

    @Override
    public boolean delete(int id) {
        Author author = getById(  id);
        if (author==null)   return false;
        authorRepository.delete(author);
        return true;
    }
}
