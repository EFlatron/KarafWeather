package com.nix.weather.impl;

import com.nix.weather.api.Weather;

public interface WeatherService {
    Weather getWeatherByCity(String city);
}
