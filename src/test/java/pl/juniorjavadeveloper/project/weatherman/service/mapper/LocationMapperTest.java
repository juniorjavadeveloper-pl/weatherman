package pl.juniorjavadeveloper.project.weatherman.service.mapper;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.LocationEntity;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import static org.junit.jupiter.api.Assertions.*;

class LocationMapperTest {

    private static final String LOCATION_CITY_WARSZAWA = "Warszawa";
    private static final String LOCATION_COUNTRY_CODE = "PL";
    private static final double LOCATION_TEMPERATURE_21_5 = 21.5;

    @Test
    void givenMapperAndModel_whenMap_thenEntityFieldsMapped() {
        // given
        LocationMapper locationMapper = new LocationMapper();
        LocationModel locationModel = LocationModel.builder()
                .city(LOCATION_CITY_WARSZAWA)
                .countryCode(LOCATION_COUNTRY_CODE)
                .temperature(LOCATION_TEMPERATURE_21_5)
                .build();

        // when
        LocationEntity locationEntity = locationMapper.from(locationModel);

        // then
        assertAll(
                () -> assertNotNull(locationEntity, "locationEntity is null"),
                () -> assertNull(locationEntity.getId(), "locationEntity ID is not null"),
                () -> assertEquals(LOCATION_CITY_WARSZAWA, locationEntity.getCity(), "locationEntity CITY is null"),
                () -> assertEquals(LOCATION_COUNTRY_CODE, locationEntity.getCountryCode(), "locationEntity COUNTRY CODE is null"),
                () -> assertEquals(LOCATION_TEMPERATURE_21_5, locationEntity.getTemperature(), "locationEntity TEMPERATURE is null")
        );
    }
}