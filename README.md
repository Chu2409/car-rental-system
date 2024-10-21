## Description

REST API to manage car rental

## Tecnologies

- Java
- Spring Boot
- Docker
- Postgres

## Requirements

- Java 21

## Installation

1. Set environment variables in .env file

2. Set up the docker environment:

```bash
$ docker compose up -d

```

3. Run application:

```bash
# development
$ ./mvnw spring-boot:run

# production
$ ./mvnw clean compile
$ ./mvnw clean package
$ java -jar .\target\invoicer-0.0.1-SNAPSHOT.jar
```
