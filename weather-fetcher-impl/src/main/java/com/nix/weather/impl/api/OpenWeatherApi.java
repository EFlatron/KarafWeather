package com.nix.weather.impl.api;

import com.nix.weather.impl.openweather.model.OpenWeatherModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyReader;

@Path("/data/2.5")
public interface OpenWeatherApi extends MessageBodyReader<OpenWeatherModel> {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/weather")
    OpenWeatherModel getWeatherByCity(@QueryParam("q") String name,
                                      @QueryParam("appid") String id,
                                      @QueryParam("units") String metric);

}
