# Maven + Java Spring

Following this [tutorial](https://spring.io/guides/gs/spring-boot).

## Setup

### Run with maven

```bash
cd backend
mvn install
mvn springboot:run
```

### Run with docker

```bash
docker build -f Dockerfile -t backend:dev .
docker run --rm -p 8080:8080 --name backend_dev -d backend:dev
```

## Test

### Run tests

```bash
cd backend
mvn test
```
