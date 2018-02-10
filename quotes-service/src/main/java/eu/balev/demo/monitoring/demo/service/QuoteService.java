package eu.balev.demo.monitoring.demo.service;

import eu.balev.demo.monitoring.demo.domain.QuoteEntity;
import eu.balev.demo.monitoring.demo.domain.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

  private QuoteRepository quoteRepository;

  @Autowired
  public QuoteService(QuoteRepository quoteRepository) {
    this.quoteRepository = quoteRepository;
  }

  /**
   * Returns a random quote from our database with wisdom.
   *
   * @return a random quote. Cannot be null. The database is full with clever quotes.
   */
  public QuoteEntity getRandomQuote() {

    long totalCount = quoteRepository.count();

    int idx = (int) (Math.random() * totalCount);

    Page<QuoteEntity> questionPage = quoteRepository.findAll(new PageRequest(idx, 1));
    QuoteEntity quote = null;
    if (questionPage.hasContent()) {
      quote = questionPage.getContent().get(0);
    }
    return quote;
  }
}
