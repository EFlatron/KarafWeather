package com.nix.weather.impl.props;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherProperties {

    private String appId;
    private String units;
    private String baseAddress;

}
