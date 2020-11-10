package gr.athtech.restapi.service.impl;

import gr.athtech.restapi.dto.AuthorDto;
import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.repository.AuthorRepository;
import gr.athtech.restapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorDbServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        if (authorDto==null) return null;
        Author author = AuthorDto.getAuthor(authorDto);
        return    AuthorDto.getAuthorDto( authorRepository.save(author));
    }

    @Override
    public AuthorDto getById(int id) {
        Optional<Author> optionAuthor = authorRepository.findById(id);
        if (optionAuthor.isEmpty()) return null;
        return    AuthorDto.getAuthorDto( optionAuthor.get());


    }

    @Override
    public List<AuthorDto> getAllAuthors() {

        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        authors.forEach( author -> authorDtos.add( AuthorDto.getAuthorDto( author)) );
        return authorDtos;
    }

    @Override
    public AuthorDto update(AuthorDto authorDto, int id) {
        Author author = AuthorDto.getAuthor(authorDto);
        return  AuthorDto.getAuthorDto( authorRepository.save(author));
    }

    @Override
    public boolean delete(int id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isEmpty())   return false;
        authorRepository.delete(author.get());
        return true;
    }
}
