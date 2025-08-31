FROM maven:3.9-amazoncorretto-24-alpine

WORKDIR /build
COPY pom.xml .
RUN mvn dependency:resolve

COPY src src
RUN mvn install


FROM openjdk:24-jdk-slim

LABEL org.opencontainers.image.source=https://github.com/Matthiosso/website
LABEL org.opencontainers.image.description="Portfolio Website Backend using Java Spring and Maven"

WORKDIR /app
RUN apt-get update

COPY --from=0 /build/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=container", "/app/app.jar"]