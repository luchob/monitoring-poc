package eu.balev.demo.monitoring.demo.init;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Just a demo histogram.
 */
public class DemoDistribution implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoCounters.class);
  //
  private final DistributionSummary summary;

  private final Random r = new Random();

  DemoDistribution(MeterRegistry meterRegistry) {
    summary = DistributionSummary
        .builder("demoservice_distribution")
        .description("Just a demo distribution") // optional
        .publishPercentileHistogram()
        .maximumExpectedValue(40L)
        .register(meterRegistry);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
        long value = Math.abs(Math.round(r.nextGaussian() * 15));
        summary.record(value);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        LOGGER.error("S.o. interrupted me and I'll go away :( Bye!", e);
        return;
      }
    }
  }
}
