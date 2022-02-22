FROM maven:3.6.3-jdk-11 AS build
COPY . weather-fetcher
WORKDIR weather-fetcher
RUN mvn clean install

FROM apache/karaf:4.3.6

COPY ./etc /opt/apache-karaf/etc

COPY --from=build /root/.m2/repository $KARAF_HOME/system

EXPOSE 8101 1099 44444 8181 9999
CMD ["karaf", "run"]