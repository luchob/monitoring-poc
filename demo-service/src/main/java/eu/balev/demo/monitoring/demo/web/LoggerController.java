package eu.balev.demo.monitoring.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is just a demo controller that does some demo-purpose logging
 * with slf4j.
 */
@RestController
@RequestMapping("/api/logger")
public class LoggerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggerController.class);

  @GetMapping("error")
  public String logErrorMessage(@RequestParam("message") String message)
  {
    LOGGER.error("Received ERROR: {}", message);
    return message;
  }

  @GetMapping("warn")
  public String logWarnMessage(@RequestParam("message") String message)
  {
    LOGGER.warn("Received WARN: {}", message);
    return message;
  }
}
