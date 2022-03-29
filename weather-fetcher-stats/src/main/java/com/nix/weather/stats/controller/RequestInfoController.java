package com.nix.weather.stats.controller;

import com.nix.weather.stats.model.CityStats;
import com.nix.weather.stats.repository.RequestInfoRepository;
import com.nix.weather.stats.service.RequestInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather-stats")
public class RequestInfoController {

    private final RequestInfoService service;

    @GetMapping("/cities/count")
    public List<CityStats> getCountCities() {
        return service.getCountCities();
    }

}