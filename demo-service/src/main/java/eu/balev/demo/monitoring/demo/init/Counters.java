package eu.balev.demo.monitoring.demo.init;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counters implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(Counters.class);
  //
  final Counter beat1, beat2;

  Counters(MeterRegistry meterRegistry) {
    beat1 = Counter
        .builder("demoservice_heart_beat")
        .description("a simple counter")
        .tags("beat", "beat1")
        .register(meterRegistry);

    beat2 = Counter
        .builder("demoservice_heart_beat")
        .description("a simple faster counter")
        .tags("beat", "beat2")
        .register(meterRegistry);
  }

  @Override
  public void run() {
    while(true) {
      try {
        Thread.sleep(1000);
        beat1.increment(0.5);
        beat2.increment(1);
      } catch (InterruptedException e) {
        Thread.interrupted();
        LOGGER.error("S.o. interrupted me and I'll go away :( Bye!", e);
        return;
      }
    }
  }
}
