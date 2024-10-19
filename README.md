#  EA FC / FIFA Career Manager Repository Tracker

> Spring Boot 3 Backend for fccareermanager project including multi module Gradle build tools

>Modules: 
> - `transfer-history` for anything Transfer and Loan Deal related

## Initial Set Up

### Setting up pgAdmin and database

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

____

## Start up 

1. Start application per module by running `*Application.java` file
2. 
