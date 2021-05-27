package pl.juniorjavadeveloper.project.weatherman.service;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service.OpenWeatherApiCurrentWeatherDataService;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;
import pl.juniorjavadeveloper.project.weatherman.model.WeatherDataRequestModel;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.LocationMapper;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.OpenWeatherMapper;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.WeatherDataRequestMapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeathermanManagerServiceIntegrationTest {

    private static final String LOCATION_CITY_WARSZAWA = "Warszawa";
    private static final String LOCATION_COUNTRY_CODE = "PL";
    private static final double LOCATION_TEMPERATURE_21_5 = 21.5;

    @Test
    void list() {
    }

    @Test
    void givenService_whenCreateLocation_thenCreatedLocationFieldsCorrect() {
        // given
        LocationMapper locationMapper = new LocationMapper();
        WeatherDataRequestMapper weatherDataRequestMapper = new WeatherDataRequestMapper();
        OpenWeatherMapper openWeatherMapper = new OpenWeatherMapper();

        HibernateWeathermanDao hibernateWeatherDao = new HibernateWeathermanDao();
        WeathermanService weathermanService = new WeathermanService(hibernateWeatherDao, locationMapper);
        OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService = new OpenWeatherApiCurrentWeatherDataService();

        WeathermanManagerService weathermanManagerService = new WeathermanManagerService(
                weathermanService, openWeatherApiCurrentWeatherDataService,
                locationMapper, weatherDataRequestMapper, openWeatherMapper);

        WeatherDataRequestModel weatherDataRequestModel = new WeatherDataRequestModel(LOCATION_CITY_WARSZAWA, LOCATION_COUNTRY_CODE);

        // when
        LocationModel createdLocationModel = weathermanManagerService.create(weatherDataRequestModel);
        LocationModel readLocationModel = weathermanService.read(createdLocationModel.getId());

        // then
        assertAll(
                () -> assertNotNull(createdLocationModel, "createdLocationModel is null"),
                () -> assertNotNull(readLocationModel, "readLocationModel is null"),

//                () -> assertEquals(LOCATION_CITY_WARSZAWA, createdLocationModel.getCity(), "createdLocationModel CITY is null"),
                () -> assertEquals(LOCATION_COUNTRY_CODE, createdLocationModel.getCountryCode(), "createdLocationModel COUNTRY CODE is null"),

//                () -> assertEquals(LOCATION_CITY_WARSZAWA, readLocationModel.getCity(), "readLocationModel CITY is null"),
                () -> assertEquals(LOCATION_COUNTRY_CODE, readLocationModel.getCountryCode(), "readLocationModel COUNTRY CODE is null"),

                () -> assertEquals(createdLocationModel.getTemperature(), readLocationModel.getTemperature(), "TEMPERATURE are not equal")
        );
    }

    @Test
    void read() {
    }
}