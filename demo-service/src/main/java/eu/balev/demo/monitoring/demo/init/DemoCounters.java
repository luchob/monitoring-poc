package eu.balev.demo.monitoring.demo.init;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines two sample counters belonging to the same
 * metrics named <pre>demoservice_heart_beat</pre>.
 *
 * The first counter is labelled with <pre>beat=beat2</pre>
 * and the second one is labelled with <pre>beat=beat2</pre>.
 * Both form two time series.
 */
public class DemoCounters implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoCounters.class);
  //
  private final Counter beat1, beat2;

  DemoCounters(MeterRegistry meterRegistry) {
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
        Thread.currentThread().interrupt();
        LOGGER.error("S.o. interrupted me and I'll go away :( Bye!", e);
        return;
      }
    }
  }
}
