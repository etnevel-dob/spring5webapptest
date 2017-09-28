package hu.yellowroad.spring5webapp.repositories;

import hu.yellowroad.spring5webapp.model.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
