package pl.juniorjavadeveloper.project.weatherman.service.mapper;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.LocationEntity;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import static org.junit.jupiter.api.Assertions.*;

class LocationModelMapperTest {

    private static final String LOCATION_CITY_WARSZAWA = "Warszawa";
    private static final String LOCATION_COUNTRY_CODE = "PL";
    private static final double LOCATION_TEMPERATURE_21_5 = 21.5;

    @Test
    void givenMapperAndModel_whenMap_thenEntityFieldsMapped() {
        // given
        LocationModelMapper locationModelMapper = new LocationModelMapper();
        LocationModel locationModel = LocationModel.builder()
                .city(LOCATION_CITY_WARSZAWA)
                .countryCode(LOCATION_COUNTRY_CODE)
                .temperature(LOCATION_TEMPERATURE_21_5)
                .build();

        // when
        LocationEntity locationEntity = locationModelMapper.from(locationModel);

        // then
        assertAll(
                () -> assertNotNull(locationEntity, "locationEntity is null"),
                () -> assertNull(locationEntity.getId(), "locationEntity ID is not null"),
                () -> assertEquals(locationEntity.getCity(), LOCATION_CITY_WARSZAWA),
                () -> assertEquals(locationEntity.getCountryCode(), LOCATION_COUNTRY_CODE),
                () -> assertEquals(locationEntity.getTemperature(), LOCATION_TEMPERATURE_21_5)
        );
    }
}