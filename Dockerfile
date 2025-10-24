FROM maven:3.8-openjdk-8

WORKDIR /app

COPY pom.xml /app
COPY src /app/src

RUN mvn clean package -Dmaven.test.skip=true
