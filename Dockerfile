FROM maven:3.6.3-jdk-11 AS build
COPY . weather-fetcher
WORKDIR weather-fetcher
RUN mvn clean install

FROM adoptopenjdk:11-jre-hotspot

ENV KARAF_INSTALL_PATH /opt
ENV KARAF_HOME $KARAF_INSTALL_PATH/apache-karaf-4.3.6
ENV KARAF_EXEC exec
ENV PATH $PATH:$KARAF_HOME/bin

COPY weather-fetcher-docker/target/assembly $KARAF_HOME
COPY weather-fetcher-docker/etc $KARAF_HOME/etc
COPY --from=build /root/.m2/repository $KARAF_HOME/system

EXPOSE 8101 1099 44444 8181 9999
CMD ["karaf", "run"]