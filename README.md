# Welcome

This project contains a small application which will serve as a foundation for an _eventual_ (if approved) session at jPriome.io, May 2018. 

---
**Current Status**: The project is under development and is used for the CFP. 
Intensive improvements are expected after mid March of 2018 . 
The session agenda may be a subject of minor improvements. 
Any contributions and opinions are welcome.

# Session description and agenda plan

## Monitoring Spring applications with Prometheus, Grafana and Alert Manager

The session will explain how does a monitoring solution based on these technologies works and what are the benefits of it.
The ambitious goal is that the attendees will learn enough so that they can build similar solution by themselves.
The practical part will be backed up with a GitHub project and the necessary infrastructure will be dockerized
so that anyone with a Docker installed will be able to get up running very fast, experiment and have fun.

### Some theory:

 * What is service monitoring and why is it so important (esp. in micro service architectures)?
 * High level overview of the elements of the monitoring solution - what is the role of each element?
 * What is Prometheus and how does it work? Time series, metric types (counter, gauge, histogram), etc. Some live examples.
 * What is Grafana?

### Practical part 1:

  * Introducing a very simplified Spring App - service for delivery of wise quotes;
  * Spring/Prometheus integration - API-s.
  * The role of Spring Actuator.
  * logging with Logback.
  * Quick introduction of small and simple Angular UI dashboard reading from the source of wisdom. This part will be utterly neglected.
  * Integrating with Prometheus and Grafana.
  * Building a sample dashboard showing some metrics coming from the Spring service.

### Practical part 2:

  * Showing some real dashboards that we have built. 
  * Mentioning the hardware that we use for visualization
    * TV sets
    * Intel NUC
    * frame and final appereance

### Q&A:

  * A small time slot for Q&A.
