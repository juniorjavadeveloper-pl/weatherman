package pl.juniorjavadeveloper.project.weatherman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {
    private Long id;

    private String city;
    private String countryCode;

    private double latitude;
    private double longitude;

    private double temperature;
    private int pressure;
    private int humidity;
    private double windSpeed;
}
