package springframeworkbeginning.demoframework.WebApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import springframeworkbeginning.demoframework.WebApp.model.Publisher;
import springframeworkbeginning.demoframework.WebApp.repositories.AuthorRepository;
import springframeworkbeginning.demoframework.WebApp.repositories.BookRepository;
import springframeworkbeginning.demoframework.WebApp.model.Author;
import springframeworkbeginning.demoframework.WebApp.model.Book;
import springframeworkbeginning.demoframework.WebApp.repositories.PublisherRepository;

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
        Publisher publisher=new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //eric
        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Hello world","1234",publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //rod
        Author rod=new Author("rod","john");
        Book d2=new Book("hello world part 2","123456",publisher);
        rod.getBooks().add(d2);

        authorRepository.save(rod);
        bookRepository.save(d2);

    }
}


