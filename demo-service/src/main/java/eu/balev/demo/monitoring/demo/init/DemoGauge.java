package eu.balev.demo.monitoring.demo.init;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.function.ToDoubleFunction;

class DemoGauge {

  DemoGauge(MeterRegistry meterRegistry) {
    //All of the different forms of creating a gauge maintain
    //only a weak reference to the object being observed,
    //so as not to prevent garbage collection of the object.

    Oscillator oscillator = new Oscillator();
    Gauge
        .builder("demoservice_gauge", oscillator, oscillator)
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
      return result;
    }
  }
}