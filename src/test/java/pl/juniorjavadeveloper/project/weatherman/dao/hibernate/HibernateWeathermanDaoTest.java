package pl.juniorjavadeveloper.project.weatherman.dao.hibernate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateWeathermanDaoTest {

    private static final int LOCATIONS_SIZE_1 = 1;

    @Test
    void givenDaoAndLocationEntity_whenCreateAndList_thenLocationsSizeOne() {
        // given
        HibernateWeathermanDao dao = new HibernateWeathermanDao();
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setCity("Warszawa");
        locationEntity.setTemperature(21.5);

        // when
        dao.create(locationEntity);
        List<LocationEntity> locations = dao.list();

        // then
        assertEquals(LOCATIONS_SIZE_1, locations.size(), "locations size is not equal");
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }
}