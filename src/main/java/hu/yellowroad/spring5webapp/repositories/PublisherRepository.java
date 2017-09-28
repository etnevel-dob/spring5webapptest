package hu.yellowroad.spring5webapp.repositories;

import hu.yellowroad.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
