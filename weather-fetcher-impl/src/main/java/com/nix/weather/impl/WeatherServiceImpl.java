package com.nix.weather.impl;

import com.nix.weather.api.WeatherService;
import com.nix.weather.api.model.WeatherModel;
import com.nix.weather.impl.api.OpenWeatherApi;
import com.nix.weather.impl.openweather.mapper.WeatherMapper;
import com.nix.weather.impl.openweather.model.OpenWeatherModel;
import com.nix.weather.impl.props.OpenWeatherProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final OpenWeatherApi openWeatherApi;
    private final OpenWeatherProperties properties;
    private final WeatherMapper weatherMapper;

    @Override
    public WeatherModel getWeatherByCity(String city) {
        OpenWeatherModel openWeatherModel = openWeatherApi.getWeatherByCity(getCity(city),
                properties.getAppId(),
                properties.getUnits());
        return weatherMapper.openWeatherModelToWeatherModel(openWeatherModel);
    }

    private String getCity(String city) {
        return String.format("%s", city);
    }

}