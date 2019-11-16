package springframeworkbeginning.demoframework.WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframeworkbeginning.demoframework.WebApp.model.Author;

public interface AuthorRepository extends CrudRepository <Author, Long>{
}
