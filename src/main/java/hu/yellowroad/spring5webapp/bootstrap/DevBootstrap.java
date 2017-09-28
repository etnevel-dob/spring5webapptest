package hu.yellowroad.spring5webapp.bootstrap;

import hu.yellowroad.spring5webapp.model.Author;
import hu.yellowroad.spring5webapp.model.Book;
import hu.yellowroad.spring5webapp.model.Publisher;
import hu.yellowroad.spring5webapp.repositories.AuthorRepository;
import hu.yellowroad.spring5webapp.repositories.BookRepository;
import hu.yellowroad.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "1117 Budapest, Szerémi sor 12/a");
        Book ddd = new Book("Domain-Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harperCollins);
        bookRepository.save(ddd);


        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "1158 Budapest, Pörge u. 95.");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);
    }
}
