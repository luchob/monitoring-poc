package eu.balev.demo.monitoring.demo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {

    (new Thread(new Counters())).start();
  }
}

