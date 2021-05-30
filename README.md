# Job Batch API Module

* [Summary](#markdown-header-summary)
* [Prerequisites](#markdown-header-prerequisites)
* [Build](#markdown-header-build)
* [High Level Overview](#markdown-header-high-level-overview)
* [Run](#markdown-header-run)
* [Author](#markdown-header-author)

## Summary
Job Batch is admin api which currently provides 
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

As a part of job batch execution there is requirement to know status of the jobs executed.This provides the same.
## Deploy

Clone locally
Execute standard maven deploy command to build and deploy library into Artifact repository.

```shell
# Build and deploy
mvn clean deploy
```

## Whom do I talk to, for further queries?

* Repo owner - maheshsapre@gmail.com
