#  EA FC / FIFA Career Manager Repository Tracker

> Spring Boot 3 Backend for fccareermanager project including multi module Gradle build tools

>Modules: 
> - `transfer-history` for anything Transfer and Loan Deal related

## Initial Set Up

### Setting up pgAdmin and database

#### Using `docker-compose.yaml`
**URL:** http://localhost:5852/browser/

Adding a new server

**General Tab**

Name: fccareermanager-db_name (ie: fccareermanager-transferhistory)

**Connection Tab**

Host name/address: use your LAN IP address instead of localhost

Port number: Use the forwarded port number for the server/db that you are adding that you used in docker-compose.yaml (ie: - "5892:5432" 5892 is the port number to use)

Maintenance database: postgres

Username: same as in application.yml

Password: same as in application.yml

#### If not using `docker-compose.yaml` for postgresql and instead using a standalone postgresql instance:

1. Need to create a database called `tds` via pgadmin or via psql cli
2. If not already, create tds user and give SUPERUSER and LOGIN roles. Follow this link for guidance: https://github.com/kuelteabmas/techtips/blob/main/databases/postgresql.md

____
## Contribution
### Start up 

#### Using IntelliJ's Run Configuration
* Start application per module by running `*Application.java` file

#### Pull and Run Docker Image locally
* Run command: `./run-image-locally.yaml`

### Building and pushing image to DockerHub

1. Need to have Docker credentials for your CLI. You can check `~/.docker/config.json` if it's present and have token contents. Start here https://docs.docker.com/reference/cli/docker/login/ if needed
2. Run `./gradlew jib` and it's package, build and push the created image to your DockerHub repo 
3. (Optional) Run locally:  docker run --rm --name fccareermanager-transferhistory -p 8899:8892 kuelteabmas/fccareermanager-transferhistory:1.0.5-SNAPSHOT

--- 

## APIs

### Transfer History API
This service manages anything deal related, transfer or loan including the following components:
* Tracks Player Growth during a Loan Spell
* Gathers financials of a deal (loan or transfer)
* Gathers negotiation details of a deal including: player involved, deal type, to and from team, duration of contract

### Performances API

This service contains all things performance related including match facts summary.

## Tools

### Eureka Server - Service Registration and Service Discovery

* act as a **Centralized Service Registry** to automatically register the services and **Client Registration**
* act as a **Load Balancer** among the service instances
* perform **Health Checks** on registered services, ensuring robustness and reliability

### Eureka Clients - API Gateway
All APIs are declared within `appication.yml` as Eureka Clients that the Eureka Server will manage

### Zipkin - Distributed Tracing
**Zipkin** for **Distributed Tracing**

It helps gather timing data needed to troubleshoot latency problems in service architectures. Features include both the collection and lookup of this data.


## Communication
### via Feign Clients
Clients package
APIs currently communicated by making HTTP calls to each other

## Database
Persistence: **PostgreSQL**
Each service has its own database configured in their `application.yml`

Dashboard & UI: **PGAdmin**
PGAdmin is used as a management dashboard for all databases

## Infrastructure
Docker for containerization
Gradle (Multi Module with `buildSrc` module) and Jib for packaging

## CI/CD
CI: **GitHub Actions**

CD: **Jenkins**
Application has a `JenkinsFile` containing the pipeline stages and steps for building, packaging and pushing to Docker Hub

## Common Utilities
**TDSCommons** repo for common utility methods between APIs such as:
* Create a database for API if it doesn't exist: `createDbIfNotExists()` 