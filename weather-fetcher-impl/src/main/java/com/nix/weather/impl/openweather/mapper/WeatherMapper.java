package com.nix.weather.impl.openweather.mapper;

import com.nix.weather.api.model.WeatherModel;
import com.nix.weather.impl.openweather.model.OpenWeatherModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(target = "temp", source = "main.temp")
    @Mapping(target = "feelsLike", source = "main.feelsLike")
    @Mapping(target = "tempMin", source = "main.tempMin")
    @Mapping(target = "tempMax", source = "main.tempMax")
    @Mapping(target = "pressure", source = "main.pressure")
    @Mapping(target = "humidity", source = "main.humidity")
    WeatherModel openWeatherModelToWeatherModel(OpenWeatherModel openWeatherModel);

    @AfterMapping
    default void after(@MappingTarget WeatherModel.WeatherModelBuilder weather, OpenWeatherModel openWeatherModel) {
        if(!openWeatherModel.getWeather().isEmpty()) {
            weather.state(openWeatherModel.getWeather().get(0).getMain());
        } else {
            weather.state("no description");
        }
    }
}
