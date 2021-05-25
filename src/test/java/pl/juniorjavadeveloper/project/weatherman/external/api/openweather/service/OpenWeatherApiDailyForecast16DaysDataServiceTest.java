package pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.forecast.OpenWeatherApiDailyForecast16DaysDataResponse;
import pl.juniorjavadeveloper.project.weatherman.model.WeatherDataRequestModel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenWeatherApiDailyForecast16DaysDataServiceTest {

    @Test
    void givenService_whenGetWeatherForecastByLocationName_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiDailyForecast16DaysDataService service = new OpenWeatherApiDailyForecast16DaysDataService();
        WeatherDataRequestModel weatherDataRequestModel = new WeatherDataRequestModel("Warszawa", "PL", 3);

        // when
        OpenWeatherApiDailyForecast16DaysDataResponse weatherDataResponse = service.getWeatherForecast(weatherDataRequestModel);

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }

    @Test
    void givenService_whenGetWeatherForecastByLatitudeAndLongitude_thenWeatherDataResponseNotNull() {
        // given
        OpenWeatherApiDailyForecast16DaysDataService service = new OpenWeatherApiDailyForecast16DaysDataService();
        WeatherDataRequestModel weatherDataRequestModel = new WeatherDataRequestModel(52.229675, 21.012230, 3);

        // when
        OpenWeatherApiDailyForecast16DaysDataResponse weatherDataResponse = service.getWeatherForecast(weatherDataRequestModel);

        // then
        assertNotNull(weatherDataResponse, "weatherDataResponse is null");
    }
}