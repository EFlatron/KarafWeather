## Build
`
mvn clean install
`

# How-to run


1. Karaf commands:
   - feature:repo-add mvn:com.nix/karaf-rest-weather-features/1.0.0/xml
   - feature:install karaf-rest-weather-impl
   - feature:install felix-http
2. Go to http://localhost:8181/cxf/weather/city/Kharkiv
