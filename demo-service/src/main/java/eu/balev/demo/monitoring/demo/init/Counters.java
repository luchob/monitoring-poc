package eu.balev.demo.monitoring.demo.init;

import io.prometheus.client.Counter;

public class Counters implements Runnable {

  static final Counter cnt =
      Counter.
          build().
          name("demoservice_heart_beat").
          labelNames("beat").
          help("Increases by 1, starts at 1").
          register();

  Counters() {

  }

  @Override
  public void run() {
    while(true) {
      try {
        Thread.sleep(1000);
        cnt.labels("beat_one").inc();
        cnt.labels("beat_two").inc(0.5);
      } catch (InterruptedException e) {
        Thread.interrupted();
        return;
      }
    }
  }
}
