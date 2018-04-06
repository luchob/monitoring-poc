package eu.balev.demo.monitoring.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AliasWebConfig implements WebMvcConfigurer {


  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    //well, that's just for the compatibility with the toolbox...
    registry.addViewController("/prometheus").setViewName("forward:/actuator/prometheus");
  }
}
