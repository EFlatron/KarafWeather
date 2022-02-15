package com.nix.weather.impl.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.Collections;

public class OpenWeatherApiFactory {

    public static OpenWeatherApi create(String baseUrl) {
        return JAXRSClientFactory.create(baseUrl,
                OpenWeatherApi.class,
                Collections.singletonList(new JacksonJsonProvider()));
    }

}