package pl.juniorjavadeveloper.project.weatherman.dao.hibernate;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HibernateWeathermanDaoTest {

    private static final int LOCATIONS_SIZE_1 = 1;

    private static final String LOCATION_CITY_WARSZAWA = "Warszawa";
    private static final double LOCATION_TEMPERATURE_21_5 = 21.5;

    private static final String LOCATION_UPDATE_CITY_LUBLIN = "Lublin";
    private static final double LOCATION_UPDATE_TEMPERATURE_31_5 = 31.5;

    @Test
    void givenDaoAndLocationEntity_whenCreateAndList_thenLocationsSizeOne() {
        // given
        HibernateWeathermanDao dao = new HibernateWeathermanDao();
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCity(LOCATION_CITY_WARSZAWA);
        locationEntity.setTemperature(LOCATION_TEMPERATURE_21_5);

        // when
        dao.create(locationEntity);
        List<LocationEntity> locations = dao.list();

        // then
        assertEquals(LOCATIONS_SIZE_1, locations.size(), "locations size is not equal");
    }

    @Test
    void givenDaoAndLocationEntity_whenCreate_thenCreatedEntityIdIsNotNull() {
        // given
        HibernateWeathermanDao dao = new HibernateWeathermanDao();
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCity(LOCATION_CITY_WARSZAWA);
        locationEntity.setTemperature(LOCATION_TEMPERATURE_21_5);

        // when
        LocationEntity createdLocationEntity = dao.create(locationEntity);

        // then
        assertNotNull(createdLocationEntity.getId(), "createdLocationEntity ID is null");
    }

    @Test
    void givenDaoAndLocationEntity_whenReadById_thenReadLocationEntityIsEqual() {
        // given
        HibernateWeathermanDao dao = new HibernateWeathermanDao();

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCity(LOCATION_CITY_WARSZAWA);
        locationEntity.setTemperature(LOCATION_TEMPERATURE_21_5);

        // when
        LocationEntity createdLocationEntity = dao.create(locationEntity);
        LocationEntity readLocationEntity = dao.read(createdLocationEntity.getId());

        // then
        assertAll(
                () -> assertEquals(LOCATION_CITY_WARSZAWA, readLocationEntity.getCity(), "City names are not equal"),
                () -> assertEquals(LOCATION_TEMPERATURE_21_5, readLocationEntity.getTemperature(), "Temperatures are not equal")
        );
    }

    @Test
    void givenDaoAndLocationEntities_whenCreateAndUpdate_thenUpdatedLocationEntityIsEqual() {
        // given
        HibernateWeathermanDao dao = new HibernateWeathermanDao();

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCity(LOCATION_CITY_WARSZAWA);
        locationEntity.setTemperature(LOCATION_TEMPERATURE_21_5);

        LocationEntity updateLocationEntity = new LocationEntity();
        updateLocationEntity.setCity(LOCATION_UPDATE_CITY_LUBLIN);
        updateLocationEntity.setTemperature(LOCATION_UPDATE_TEMPERATURE_31_5);

        // when
        LocationEntity createdLocationEntity = dao.create(locationEntity);

        Long locationEntityId = createdLocationEntity.getId();
        updateLocationEntity.setId(locationEntityId);

        dao.update(updateLocationEntity);
        LocationEntity readLocationEntity = dao.read(locationEntityId);

        // then
        assertAll(
                () -> assertEquals(locationEntityId, readLocationEntity.getId(), "Ids are not equal"),
                () -> assertEquals(LOCATION_UPDATE_CITY_LUBLIN, readLocationEntity.getCity(), "City names are not equal"),
                () -> assertEquals(LOCATION_UPDATE_TEMPERATURE_31_5, readLocationEntity.getTemperature(), "Temperatures are not equal")
        );
    }
}