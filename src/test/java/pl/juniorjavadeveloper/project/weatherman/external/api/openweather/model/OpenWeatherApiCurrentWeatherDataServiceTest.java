package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenWeatherApiCurrentWeatherDataServiceTest {

    @Test
    void givenService_whenGetWeather_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiCurrentWeatherDataService service = new OpenWeatherApiCurrentWeatherDataService();

        // when
        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = service.getWeather();

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }
}