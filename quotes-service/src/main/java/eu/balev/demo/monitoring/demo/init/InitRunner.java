package eu.balev.demo.monitoring.demo.init;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.balev.demo.monitoring.demo.domain.AuthorEntity;
import eu.balev.demo.monitoring.demo.domain.AuthorRepository;
import eu.balev.demo.monitoring.demo.domain.QuoteEntity;
import eu.balev.demo.monitoring.demo.domain.QuoteRepository;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * This class will read all quotes form our small file full with wisdom.
 *
 * We will transfer the whole amount of wisdom into a database then.
 */
@Component
public class InitRunner implements CommandLineRunner {

  private AuthorRepository authorRepository;
  private QuoteRepository quoteRepository;

  public InitRunner(AuthorRepository authorRepository,
      QuoteRepository quoteRepository) {
    this.authorRepository = authorRepository;
    this.quoteRepository = quoteRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    //read all quotes
    Resource resource = new ClassPathResource("quotes/quotes.json");
    List<Quote> quotesList;
    try (InputStream resourceInputStream = resource.getInputStream()) {
      ObjectMapper objectMapper = new ObjectMapper();
      quotesList = objectMapper.readValue(resourceInputStream, new TypeReference<List<Quote>>() {
      });
    }

    quotesList.forEach(this::processQuote);
  }

  private void processQuote(Quote quote) {

    Optional<AuthorEntity> authorEntityOpt = authorRepository.findByName(quote.getQuoteAuthor());
    AuthorEntity authorEntity;
    if (!authorEntityOpt.isPresent()) {
      authorEntity = asAuthor(quote.getQuoteAuthor());
      authorRepository.save(authorEntity);
    } else {
      authorEntity = authorEntityOpt.get();
    }

    QuoteEntity quoteEntity = new QuoteEntity();
    quoteEntity.setText(quote.getQuoteText());
    quoteEntity.setAuthor(authorEntity);

    quoteRepository.save(quoteEntity);
  }


  private AuthorEntity asAuthor(String authorName) {
    AuthorEntity newAuthorEntity = new AuthorEntity();
    newAuthorEntity.setName(authorName);
    return newAuthorEntity;
  }

  /**
   * A quotes POJO, used to read the source of wisdom.
   */
  private static class Quote {

    private String quoteText, quoteAuthor;

    String getQuoteAuthor() {
      return quoteAuthor;
    }

    Quote setQuoteAuthor(String quoteAuthor) {
      this.quoteAuthor = quoteAuthor;
      return this;
    }

    String getQuoteText() {
      return quoteText;
    }

    Quote setQuoteText(String quoteText) {
      Objects.requireNonNull(quoteText, "Quote text cannot be null!");

      this.quoteText = quoteText;
      return this;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append(getQuoteText());
      sb.append(" [");
      sb.append(getQuoteAuthor() != null ? getQuoteAuthor() : "Unknown");
      sb.append("]");

      return sb.toString();
    }
  }
}

