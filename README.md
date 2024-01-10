# Simona Immobilier

## Overview

Housing API based on the microservice architecture.

## Getting started

You can generate a new microservice using [this configuration on Spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.10&packaging=jar&jvmVersion=11&groupId=com.simonaimmobilier.rental&artifactId=rental-service&name=rental-service&description=Rental%20service&packageName=com.simona.rental&dependencies=web,data-jpa,postgresql)

## Usage

Run all the containers :

```bash
docker-compose up
```

You can find the Swagger documentation here: http://localhost:8080/swagger-ui.html

You can also view all the microservice instances here: http://localhost:8761

## Local development

Connect to the PostgreSQL interactive terminal `psq` with the built-in user `postgres`:

```bash
psql -U postgres
```

Create a database of each service:

```bash
create database simona_housing_service;
create database simona_rental_service;
create database simona_account_service;
```

## Deployment

Instal Istio. See: https://istio.io/latest/docs/setup/install/istioctl/

Run the following commands:

```bash
# Create pods
./init.sh

# Run the API
./run.sh
```

## Reset

```bash
minikube delete
```

type `\l` to show the list of created databases.

## Resources

(Microservices Security Using JWT - Spring Cloud Gateway - JavaTechie)[https://www.youtube.com/watch?v=MWvnmyLRUik]

## Todo

- Add authentication to housing controller
- Fix docker images using `docker buildx build --platform linux/amd64 -t antoinedespres/simona-xxx-service --push .`
