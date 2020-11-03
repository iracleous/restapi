package gr.athtech.restapi.repository;

import gr.athtech.restapi.model.Author;
import gr.athtech.restapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
