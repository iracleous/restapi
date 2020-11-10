package gr.athtech.restapi.service;

import gr.athtech.restapi.dto.AuthorDto;


import java.util.List;

public interface AuthorService {


    AuthorDto addAuthor(AuthorDto author);
    AuthorDto getById(int id);
    List<AuthorDto> getAllAuthors();
    AuthorDto update(AuthorDto author, int id);
    boolean delete(int id);

}
