package pl.juniorjavadeveloper.project.weatherman.service;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.LocationMapper;

import static org.junit.jupiter.api.Assertions.*;

class WeathermanServiceTest {

    private static final String LOCATION_CITY_WARSZAWA = "Warszawa";
    private static final String LOCATION_COUNTRY_CODE = "PL";
    private static final double LOCATION_TEMPERATURE_21_5 = 21.5;

    @Test
    void givenService_whenCreateLocation_thenCreatedLocationFieldsCorrect() {
        // given
        HibernateWeathermanDao hibernateWeatherDao = new HibernateWeathermanDao();
        LocationMapper locationMapper = new LocationMapper();
        WeathermanService weathermanService = new WeathermanService(hibernateWeatherDao, locationMapper);

        LocationModel locationModel = LocationModel.builder()
                .city(LOCATION_CITY_WARSZAWA)
                .countryCode(LOCATION_COUNTRY_CODE)
                .temperature(LOCATION_TEMPERATURE_21_5)
                .build();

        // when
        LocationModel createdLocationModel = weathermanService.create(locationModel);

        // then
        assertAll(
                () -> assertNotNull(createdLocationModel, "createdLocationModel is null"),
                () -> assertNotNull(createdLocationModel.getId(), "createdLocationModel ID is null"),
                () -> assertEquals(LOCATION_CITY_WARSZAWA, createdLocationModel.getCity(), "createdLocationModel CITY is null"),
                () -> assertEquals(LOCATION_COUNTRY_CODE, createdLocationModel.getCountryCode(), "createdLocationModel COUNTRY CODE is null"),
                () -> assertEquals(LOCATION_TEMPERATURE_21_5, createdLocationModel.getTemperature(), "createdLocationModel TEMPERATURE is null")
        );
    }
}