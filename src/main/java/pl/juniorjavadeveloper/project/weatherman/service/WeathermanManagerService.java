package pl.juniorjavadeveloper.project.weatherman.service;

import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service.OpenWeatherApiCurrentWeatherDataService;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;
import pl.juniorjavadeveloper.project.weatherman.model.WeatherDataRequestModel;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.OpenWeatherMapper;

import java.util.List;
import java.util.logging.Logger;

public class WeathermanManagerService {
    private static final Logger LOGGER = Logger.getLogger(WeathermanManagerService.class.getName());

    private final WeathermanService weathermanService;
    private final OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService;
    private final OpenWeatherMapper openWeatherMapper;

    public WeathermanManagerService(WeathermanService weathermanService,
                                    OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService,
                                    OpenWeatherMapper openWeatherMapper) {
        this.weathermanService = weathermanService;
        this.openWeatherApiCurrentWeatherDataService = openWeatherApiCurrentWeatherDataService;
        this.openWeatherMapper = openWeatherMapper;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        List<LocationModel> locationModels = weathermanService.list();
        LOGGER.info("list() = " + locationModels);
        return locationModels;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(WeatherDataRequestModel weatherDataRequestModel) {
        LOGGER.info("create(" + weatherDataRequestModel + ")");

        OpenWeatherApiCurrentWeatherDataResponse apiCurrentWeatherDataResponse =
                openWeatherApiCurrentWeatherDataService.getCurrentWeather(weatherDataRequestModel);
        LocationModel locationModel = openWeatherMapper.from(apiCurrentWeatherDataResponse);
        LocationModel createdLocationModel = weathermanService.create(locationModel);

        LOGGER.info("create(...) = " + createdLocationModel);
        return createdLocationModel;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read(" + id + ")");
        LocationModel readLocationModel = weathermanService.read(id);
        LOGGER.info("read(...) = " + readLocationModel);
        return readLocationModel;
    }
}
