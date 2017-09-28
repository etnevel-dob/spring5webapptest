package hu.yellowroad.spring5webapp.repositories;

import hu.yellowroad.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
