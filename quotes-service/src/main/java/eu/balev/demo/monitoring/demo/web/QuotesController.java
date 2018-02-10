package eu.balev.demo.monitoring.demo.web;

import eu.balev.demo.monitoring.demo.domain.QuoteEntity;
import eu.balev.demo.monitoring.demo.dto.QuoteDTO;
import eu.balev.demo.monitoring.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

  @Autowired
  QuoteService quoteService;

  @GetMapping(value = "/api/random-quote")
  public @ResponseBody QuoteDTO getRandomQuote(@PathVariable(required = false) String author) {

    QuoteEntity quoteEntity = quoteService.getRandomQuote();

    QuoteDTO quoteDTO = new QuoteDTO();
    quoteDTO.setAuthor(quoteEntity.getAuthor().getName()).
        setText(quoteEntity.getText()).
        setId(quoteEntity.getId());

    return quoteDTO;
  }

}
