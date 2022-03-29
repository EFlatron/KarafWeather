package com.nix.weather.stats.repository;

import com.nix.weather.stats.entity.RequestInfo;
import com.nix.weather.stats.model.CityStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestInfoRepository extends JpaRepository<RequestInfo, Integer> {

    @Query("SELECT DISTINCT r.countryCode as countryCode, r.city as city, COUNT(r.city) as amount \n" +
            "FROM RequestInfo r \n" +
            "GROUP BY r.city, r.countryCode \n" +
            "ORDER BY COUNT(r.city) DESC")
    List<CityStats> getCountCities();

}
