package com.nix.weather.impl;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.nix.weather.api.Weather;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    public Weather getWeatherByCity(String city) {
        String weatherKey = "5eacb3777c74185f80f1ae9dae8a6d8a";
        String units = "metric";
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=%s&APPID=%s", city, units, weatherKey);
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = builder.get();
        return response.readEntity(Weather.class);
    }
}
