package eu.balev.demo.monitoring.demo.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a sample webhook which is triggered by the Alert manager.
 */
@RestController
@RequestMapping("/api/alert")
public class AlertController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

  @RequestMapping(value = "jprime",
      method = POST,
      consumes = APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public void jprimeAlert(HttpEntity<String> httpEntity) {
    String json = httpEntity.getBody();
    LOGGER.info("JPrime alert received: {}", json);
  }

  @RequestMapping(value = "all",
      method = POST,
      consumes = APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public void defaultAlert(HttpEntity<String> httpEntity) {
    String json = httpEntity.getBody();
    LOGGER.info("JPrime alert received: {}", json);
  }
}
