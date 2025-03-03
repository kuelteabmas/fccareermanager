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

## Start up 

1. Start application per module by running `*Application.java` file

---

## Building and pushing image to DockerHub

1. Need to have Docker credentials for your CLI. You can check `~/.docker/config.json` if it's present and have token contents. Start here https://docs.docker.com/reference/cli/docker/login/ if needed
2. Run `./gradlew jib` and it's package, build and push the created image to your DockerHub repo 
3. (Optional) Run locally:  docker run --rm -p 8899:8892 kuelteabmas/fccareermanager-transferhistory:1.0.5-SNAPSHOT