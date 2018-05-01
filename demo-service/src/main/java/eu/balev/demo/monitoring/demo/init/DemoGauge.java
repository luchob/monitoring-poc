package eu.balev.demo.monitoring.demo.init;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.function.ToDoubleFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DemoGauge {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoGauge.class);

  DemoGauge(MeterRegistry meterRegistry) {
    Gauge
        .builder("demoservice_gauge", new Object(), new Oscillator())
        .description("a simple gauge")
        .register(meterRegistry);
  }

  private static class Oscillator implements ToDoubleFunction<Object> {

    private static final int AMPLITUDE = 10;

    private boolean increase = true;
    private int currentValue = 0;

    @Override
    public double applyAsDouble(Object value) {
      currentValue = currentValue + (increase ? 1 : -1);
      if (Math.abs(currentValue) >= AMPLITUDE) {
        increase = !increase;
      }
      int result =  Math.abs(currentValue);
      LOGGER.info("The current value of the gauge is {}", result);
      return result;
    }
  }
}