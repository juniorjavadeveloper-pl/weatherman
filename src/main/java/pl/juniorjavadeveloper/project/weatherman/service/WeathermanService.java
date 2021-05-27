package pl.juniorjavadeveloper.project.weatherman.service;

import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.LocationEntity;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.LocationMapper;

import java.util.List;
import java.util.logging.Logger;

public class WeathermanService {

    private static final Logger LOGGER = Logger.getLogger(WeathermanService.class.getName());

    private final HibernateWeathermanDao hibernateWeathermanDao;
    private final LocationMapper locationMapper;

    public WeathermanService(HibernateWeathermanDao hibernateWeathermanDao, LocationMapper locationMapper) {
        this.hibernateWeathermanDao = hibernateWeathermanDao;
        this.locationMapper = locationMapper;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        List<LocationEntity> locationEntities = hibernateWeathermanDao.list();
        List<LocationModel> locationModels = locationMapper.fromList(locationEntities);
        LOGGER.info("list() = " + locationModels);
        return locationModels;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(LocationModel locationModel) {
        LOGGER.info("create(" + locationModel + ")");

        LocationEntity locationEntity = locationMapper.from(locationModel);
        LocationEntity createdLocationEntity = hibernateWeathermanDao.create(locationEntity);
        LocationModel createdLocationModel = locationMapper.from(createdLocationEntity);

        LOGGER.info("create(...) = " + createdLocationModel);
        return createdLocationModel;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read(" + id + ")");
        LocationEntity locationEntity = hibernateWeathermanDao.read(id);
        LocationModel locationModel = locationMapper.from(locationEntity);
        LOGGER.info("read(...) = " + locationModel);
        return locationModel;
    }

    // U - update aka. saveLocationWeather(...)
    public LocationModel update(LocationModel locationModel) {
        LOGGER.info("update(" + locationModel + ")");

        LocationEntity locationEntity = locationMapper.from(locationModel);
        LocationEntity updatedLocationEntity = hibernateWeathermanDao.update(locationEntity);
        LocationModel updatedLocationModel = locationMapper.from(updatedLocationEntity);

        LOGGER.info("update(...) = " + updatedLocationModel);
        return updatedLocationModel;
    }

    // D - delete aka. removeLocation(...)
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        throw new UnsupportedOperationException("Operation not supported YET!");
    }
}
