## Build
`
mvn clean install
`
# How-to run
1. Karaf commands:
    - feature:repo-add mvn:com.nix/weather-fetcher-features/1.0.0-SNAPSHOT/xml
    - feature:install cxf
    - feature:install weather-fetcher-impl
2. Go to http://localhost:8181/cxf/weather/countryCode/ua/cities/Donetsk
or http://localhost:8181/cxf/weather/countryCode/ru/cities/Donetsk

# How-to run docker
- cd weather-fetcher
- docker-compose build
- docker-compose up