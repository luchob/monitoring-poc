package eu.balev.demo.monitoring.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<QuoteEntity, Integer> {

  Page<QuoteEntity> findAll(Pageable pageable);

}
