package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenWeatherApiCurrentWeatherDataServiceTest {

    @Test
    void givenService_whenGetWeatherLocationName_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiCurrentWeatherDataService service = new OpenWeatherApiCurrentWeatherDataService();
        LocationModel location = new LocationModel("Warszawa");

        // when
        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = service.getWeather(location);

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }

    @Test
    void givenService_whenGetWeatherLatitudeAndLongitude_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiCurrentWeatherDataService service = new OpenWeatherApiCurrentWeatherDataService();
        LocationModel location = new LocationModel(52.229675, 21.012230);

        // when
        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = service.getWeather(location);

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }
}