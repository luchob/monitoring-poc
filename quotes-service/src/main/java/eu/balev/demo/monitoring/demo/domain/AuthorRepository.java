package eu.balev.demo.monitoring.demo.domain;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Integer> {

  Optional<AuthorEntity> findByName(String name);
}