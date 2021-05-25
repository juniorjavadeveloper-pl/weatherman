package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weatherman.model.WeatherDataRequestModel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenWeatherApiCurrentWeatherDataServiceTest {

    @Test
    void givenService_whenGetWeatherLocationName_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiCurrentWeatherDataService service = new OpenWeatherApiCurrentWeatherDataService();
        WeatherDataRequestModel weatherDataRequestModel = new WeatherDataRequestModel("Warszawa", "PL");

        // when
        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = service.getCurrentWeather(weatherDataRequestModel);

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }

    @Test
    void givenService_whenGetWeatherLatitudeAndLongitude_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiCurrentWeatherDataService service = new OpenWeatherApiCurrentWeatherDataService();
        WeatherDataRequestModel weatherDataRequestModel = new WeatherDataRequestModel(52.229675, 21.012230);

        // when
        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = service.getCurrentWeather(weatherDataRequestModel);

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }
}