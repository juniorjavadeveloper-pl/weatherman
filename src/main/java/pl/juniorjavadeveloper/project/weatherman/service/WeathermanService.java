package pl.juniorjavadeveloper.project.weatherman.service;

import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import java.util.List;
import java.util.logging.Logger;

public class WeathermanService {

    private static final Logger LOGGER = Logger.getLogger(WeathermanService.class.getName());

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        return null;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(LocationModel locationModel) {
        LOGGER.info("create(" + locationModel + ")");
        return null;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read(" + id + ")");
        return null;
    }

    // U - update aka. saveLocationWeather(...)
    public LocationModel update(Long id, LocationModel locationModel) {
        LOGGER.info("update(" + id + ", " + locationModel + ")");
        return null;
    }

    // D - delete aka. removeLocation(...)
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        throw new UnsupportedOperationException("Operation not supported YET!");
    }
}
