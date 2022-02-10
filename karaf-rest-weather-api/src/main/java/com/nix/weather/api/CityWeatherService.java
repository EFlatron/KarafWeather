package com.nix.weather.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public interface CityWeatherService {

    @Path("/city/{city}")
    @Produces("application/json")
    @GET
    Weather getWeather(@PathParam("city") String city);
}
