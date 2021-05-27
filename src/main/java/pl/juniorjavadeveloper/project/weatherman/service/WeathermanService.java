package pl.juniorjavadeveloper.project.weatherman.service;

import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.LocationEntity;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import java.util.List;
import java.util.logging.Logger;

public class WeathermanService {

    private static final Logger LOGGER = Logger.getLogger(WeathermanService.class.getName());

    private final HibernateWeathermanDao hibernateWeathermanDao;

    public WeathermanService(HibernateWeathermanDao hibernateWeathermanDao) {
        this.hibernateWeathermanDao = hibernateWeathermanDao;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        List<LocationEntity> locationEntities = hibernateWeathermanDao.list();
        return null;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(LocationModel locationModel) {
        LOGGER.info("create(" + locationModel + ")");
//        hibernateWeathermanDao.create(locationEntity);
        return null;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read(" + id + ")");
        LocationEntity locationEntity = hibernateWeathermanDao.read(id);
        return null;
    }

    // U - update aka. saveLocationWeather(...)
    public LocationModel update(LocationModel locationModel) {
        LOGGER.info("update(" + locationModel + ")");
//        hibernateWeathermanDao.update(locationEntity);
        return null;
    }

    // D - delete aka. removeLocation(...)
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        throw new UnsupportedOperationException("Operation not supported YET!");
    }
}
