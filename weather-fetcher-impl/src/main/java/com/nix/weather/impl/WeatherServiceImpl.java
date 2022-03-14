package com.nix.weather.impl;

import com.nix.weather.api.WeatherService;
import com.nix.weather.api.model.WeatherModel;
import com.nix.weather.impl.openweather.api.OpenWeatherApi;
import com.nix.weather.impl.openweather.mapper.WeatherMapper;
import com.nix.weather.impl.openweather.model.OpenWeatherModel;
import com.nix.weather.impl.props.OpenWeatherProperties;
import com.nix.weather.persistence.entity.RequestInfo;
import com.nix.weather.persistence.repository.RequestInfoRepository;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final OpenWeatherApi openWeatherApi;
    private final OpenWeatherProperties properties;
    private final WeatherMapper weatherMapper;
    private final RequestInfoRepository requestInfoRepository;

    @Override
    public WeatherModel getWeatherByCity(String countryCode, String city) {
        OpenWeatherModel openWeatherModel = openWeatherApi.getWeatherByCity(getCityAndCode(city, countryCode),
                properties.getAppId(), properties.getUnits());

        long currentDate = new java.util.Date().getTime();
        requestInfoRepository.add(new RequestInfo(city, countryCode, new Time(currentDate), new Date(currentDate)));

        return weatherMapper.openWeatherModelToWeatherModel(openWeatherModel);
    }

    private String getCityAndCode(String city, String countryCode) {
        return String.format("%s,%s", city, countryCode);
    }

}