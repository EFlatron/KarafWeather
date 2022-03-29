FROM maven:3.6.3-jdk-11 AS build
COPY . weather-fetcher-stats
WORKDIR weather-fetcher-stats
RUN mvn clean install

FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]