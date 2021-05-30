# Job Batch API Module

* [Summary](#summary)
* [Prerequisites](#prerequisites)
* [Build](#build)
* [High Level Overview](#high-level-overview)
* [Run](#deploy)
* [Author](#author)

[img-jobbatchapi]: img/JobBatchAPI.jpeg

## Summary
+ Job Batch is admin api which currently provides 
    - /api/jobs : API lists jobs with status
    - /api/jobs : API lists job execution with details of read , write and skipped record counts

## Prerequisites

To be able to run this module it is recommended to ensure following prerequisites are fulfilled:

+ Developer is aware of tools/technologies used here:
    - Core Java and basic MVC concept
    - Spring framework (Spring DI, Beans, REST) and Springboot
    - REST API standards & JSON (un)marshalling
    - Eclipse, Junit, Maven
+ Necessary access/installation in place:
    - Eclipse (Oxygen)
    - Maven (3.5.2+)

Ensure local installation of the following softwares/tools:

* JDK - 1.8
* MongoDb - 4.0.x
* Maven - 3.6.x

---
## Build
Open your command/shell terminal and navigate to your project's root directory

#### Execute the following command to build the jar without running test cases:
mvn -U clean compile -DskipTests

## High Level Overview

This is query only module to know the jobs with there status.Its built using Spring Boot and Spring Data MongoDb.

+ Exposed API : 
    - /api/jobs : API lists jobs with status.
    - /api/jobs : API lists job execution with details of read , write and skipped record counts

+ MongoDB Collections :
    - BatchJobInstance : Maintains different jobs executed.
    - BatchJobExecution : Contains jobs execution details for the instance.
    - BatchStepExecution : Maintains steps executed as part of job execution.
    - BatchJobParameter : Maintains job execution parameters.

Diagram below, shows high level component communication for JobBatchAPI

![JobBatchAPI][img-jobbatchapi]
## Deploy

Clone locally
Execute standard maven deploy command to build and deploy library into Artifact repository.

```shell
# Build and deploy
mvn clean deploy
```
Setup MongoDb properties

```shell
spring:
    data:
        mongodb:
        #      uri: mongodb://myadmin:secret@localhost:27017/test?authSource=admin
            port: 27017
            host: localhost
            database: test
```
## Author

* Repo owner - maheshsapre@gmail.com
