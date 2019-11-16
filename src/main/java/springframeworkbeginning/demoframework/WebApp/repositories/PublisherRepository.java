package springframeworkbeginning.demoframework.WebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframeworkbeginning.demoframework.WebApp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
