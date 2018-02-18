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
  * Quick introduction of small and simple Angular UI dashboard reading from the source of wisdom (alternative to postman). This part will be utterly neglected.
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
  
# Overview

## Architecture

The next figure gives an overview of the final sample setup.

![image](https://user-images.githubusercontent.com/10339738/36351750-17206544-14b7-11e8-9397-a0b0c3bbdca3.png)

Explanation:

  * _App1_, _App2_, _AppN_ are the monitored applications/instances;
  * _Prometheus Server_ is the server that pulls metrics data that is later visualized;
  * _Alert manager_ is the tool that is sending alerts when something goes wrong - e.g. there are errors in the error log;
  * _Grafana_ is the tool which provides a visually pleasing representation of the collected metrics. It uses the query language of Prometheus.

## Visual representation

The next image shows a few gadget displaying metrics in Grafana.

![image](https://user-images.githubusercontent.com/10339738/36351870-63c99874-14b8-11e8-8658-7ecf339c0c26.png)

## Hardware setup

This image shows the hardware that we've situated in our team rooms.

![image](https://user-images.githubusercontent.com/10339738/36351906-2eb3e2ec-14b9-11e8-9c69-0b45cad100a2.png)

## Notifications

A sample HipChat notification received due to an error logged into the logs of the service.

![image](https://user-images.githubusercontent.com/10339738/36351942-94252762-14b9-11e8-8fe6-731f7c309785.png)

