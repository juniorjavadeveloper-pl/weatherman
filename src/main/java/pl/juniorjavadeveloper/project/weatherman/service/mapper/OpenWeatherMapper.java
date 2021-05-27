package pl.juniorjavadeveloper.project.weatherman.service.mapper;

import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.Coord;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.Main;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.Sys;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.Wind;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import java.util.logging.Logger;

public class OpenWeatherMapper {
    private static final Logger LOGGER = Logger.getLogger(OpenWeatherMapper.class.getName());

    public LocationModel from(OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse) {
        LOGGER.info("from(" + weatherDataResponse + ")");
        LocationModel locationModel = new LocationModel();

        if (weatherDataResponse != null) {
            Coord weatherDataResponseCoord = weatherDataResponse.getCoord();
            if (weatherDataResponseCoord != null) {
                LOGGER.info("adding weather coordinates data...");
                locationModel.setLatitude(weatherDataResponseCoord.getLat());
                locationModel.setLongitude(weatherDataResponseCoord.getLon());
            }

            Main weatherDataResponseMain = weatherDataResponse.getMain();
            if (weatherDataResponseMain != null) {
                LOGGER.info("adding weather main data...");
                locationModel.setTemperature(weatherDataResponseMain.getTemp());
                locationModel.setPressure(weatherDataResponseMain.getPressure());
                locationModel.setHumidity(weatherDataResponseMain.getHumidity());
            }

            Wind weatherDataResponseWind = weatherDataResponse.getWind();
            if (weatherDataResponseWind != null) {
                LOGGER.info("adding weather wind data...");
                locationModel.setWindSpeed(weatherDataResponseWind.getSpeed());
            }

            LOGGER.info("adding weather location info...");
            locationModel.setCity(weatherDataResponse.getName());

            Sys weatherDataResponseSys = weatherDataResponse.getSys();
            if (weatherDataResponseSys != null) {
                locationModel.setCountryCode(weatherDataResponseSys.getCountry());
            }
        }

        LOGGER.info("from(...) = " + locationModel);
        return locationModel;
    }
}
