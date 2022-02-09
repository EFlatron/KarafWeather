package com.nix.weather.impl;

import lombok.RequiredArgsConstructor;
import com.nix.weather.api.Weather;
import com.nix.weather.api.CityWeatherService;

@RequiredArgsConstructor
public class CityWeatherServiceImpl implements CityWeatherService {

    private final WeatherServiceImpl weatherServiceImpl;

    @Override
    public Weather getWeather(String city) {
        return weatherServiceImpl.getWeatherByCity(city);
    }
}