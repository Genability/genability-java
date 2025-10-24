FROM maven:3.9-eclipse-temurin-8-alpine

WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN mvn clean package -Dmaven.test.skip=true