package com.nix.weather.stats.service.impl;

import com.nix.weather.stats.model.CityStats;
import com.nix.weather.stats.repository.RequestInfoRepository;
import com.nix.weather.stats.service.RequestInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestInfoServiceImpl implements RequestInfoService {

    private final RequestInfoRepository repository;

    @Override
    public List<CityStats> getCountCities() {
        return repository.getCountCities();
    }

}
