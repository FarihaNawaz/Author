package springframeworkbeginning.demoframework.WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframeworkbeginning.demoframework.WebApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
