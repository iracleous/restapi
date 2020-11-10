package gr.athtech.restapi.dto;


import gr.athtech.restapi.model.Author;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private List<String> booktTiles;



    public static Author getAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());

        return author;
    }


    public static AuthorDto  getAuthorDto( Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
if (author.getBooks()!=null)
{
    authorDto.booktTiles = new ArrayList<>();
    author.getBooks().forEach(book ->  authorDto.booktTiles.add(book.getTitle()));
}

        return authorDto;
    }
}
