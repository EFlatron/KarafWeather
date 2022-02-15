package com.nix.weather.impl.openweather.mapper;

public class WeatherMapperFactory {

    public static WeatherMapper create() {
        return WeatherMapper.INSTANCE;
    }

}
