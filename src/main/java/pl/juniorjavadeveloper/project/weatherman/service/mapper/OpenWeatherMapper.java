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
            Main weatherDataResponseMain = weatherDataResponse.getMain();
            if (weatherDataResponseMain != null) {
                locationModel.setTemperature(weatherDataResponseMain.getTemp());
                locationModel.setPressure(weatherDataResponseMain.getPressure());
                locationModel.setHumidity(weatherDataResponseMain.getHumidity());
            }

            Wind weatherDataResponseWind = weatherDataResponse.getWind();
            if (weatherDataResponseWind != null) {
                locationModel.setWindSpeed(weatherDataResponseWind.getSpeed());
            }

//            locationModel.setCity(locationEntity.getCity());
//            locationModel.setCountryCode(locationEntity.getCountryCode());
//            locationModel.setLatitude(locationEntity.getLatitude());
//            locationModel.setLongitude(locationEntity.getLongitude());
        }

        LOGGER.info("from(...) = " + locationModel);
        return locationModel;
    }

    public LocationModel merge(LocationModel locationModel, OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse) {
        LOGGER.info("merge(" + locationModel + ", " + weatherDataResponse + ")");

        if (locationModel.getLatitude() == 0) {
            if (weatherDataResponse != null) {
                LOGGER.info("merging coordinates...");
                Coord weatherDataResponseCoord = weatherDataResponse.getCoord();
                if (weatherDataResponseCoord != null) {
                    locationModel.setLatitude(weatherDataResponseCoord.getLat());
                    locationModel.setLongitude(weatherDataResponseCoord.getLon());
                }
            }
        }

        if (locationModel.getCity() == null) {
            if (weatherDataResponse != null) {
                LOGGER.info("merging location info...");
                locationModel.setCity(weatherDataResponse.getName());

                Sys weatherDataResponseSys = weatherDataResponse.getSys();
                if (weatherDataResponseSys != null) {
                    locationModel.setCountryCode(weatherDataResponseSys.getCountry());
                }
            }
        }

        LOGGER.info("merge(...) = " + locationModel);
        return locationModel;
    }
}
