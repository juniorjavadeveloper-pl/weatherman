package pl.juniorjavadeveloper.project.weatherman.service.mapper;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.Main;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.model.current.Wind;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OpenWeatherMapperTest {

    private static final String LOCATION_CITY_WARSZAWA = "Warszawa";
    private static final String LOCATION_COUNTRY_CODE = "PL";
    private static final double LOCATION_LATITUDE_0_0 = 0.0;
    private static final double LOCATION_LATITUDE_52_2298 = 52.2298;
    private static final double LOCATION_LONGITUDE_21_0118 = 21.0118;

    private static final double LOCATION_TEMPERATURE_21_5 = 21.5;
    private static final int LOCATION_PRESSURE_1014 = 1014;
    private static final int LOCATION_HUMIDITY_50 = 50;
    private static final double LOCATION_WIND_SPEED_1_34 = 1.34;

    @Test
    void givenMapper_whenFromOpenWeatherTLTW_thenLocationModelFieldsMappedProperly() {
        // given
        OpenWeatherMapper openWeatherMapper = new OpenWeatherMapper();
        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = new OpenWeatherApiCurrentWeatherDataResponse();

        Main weatherDataMain = new Main();
        weatherDataMain.setTemp(LOCATION_TEMPERATURE_21_5);
        weatherDataMain.setPressure(LOCATION_PRESSURE_1014);
        weatherDataMain.setHumidity(LOCATION_HUMIDITY_50);
        weatherDataResponse.setMain(weatherDataMain);

        Wind weatherDataWind = new Wind();
        weatherDataWind.setSpeed(LOCATION_WIND_SPEED_1_34);
        weatherDataResponse.setWind(weatherDataWind);

        // when
        LocationModel locationModel = openWeatherMapper.from(weatherDataResponse);

        // then
        assertAll(
                () -> assertNotNull(locationModel, "locationModel is null"),
                () -> assertNull(locationModel.getCity(), "locationModel CITY is not null"),
                () -> assertEquals(LOCATION_LATITUDE_0_0, locationModel.getLatitude(), "locationModel LATITUDE is not " + LOCATION_LATITUDE_0_0),
                () -> assertNotNull(locationModel, "locationModel is null")
        );
    }

//    @Test
//    void givenMapper_whenMergeLocationModelWithOpenWeatherTLTW_thenLocationModelFieldsMergedProperly() {
//        // given
//        OpenWeatherMapper openWeatherMapper = new OpenWeatherMapper();
//
//        LocationModel locationModel = LocationModel.builder().city("Warszawa").build();
//        OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse = new OpenWeatherApiCurrentWeatherDataResponse();
//
//        weatherDataResponse.setName(LOCATION_CITY_WARSZAWA);
//
//        Coord weatherDataCoord = new Coord();
//        weatherDataCoord.setLat(LOCATION_LATITUDE_52_2298);
//        weatherDataCoord.setLon(LOCATION_LONGITUDE_21_0118);
//        weatherDataResponse.setCoord(weatherDataCoord);
//
//        Main weatherDataMain = new Main();
//        weatherDataMain.setTemp(LOCATION_TEMPERATURE_21_5);
//        weatherDataMain.setPressure(LOCATION_PRESSURE_1014);
//        weatherDataMain.setHumidity(LOCATION_HUMIDITY_50);
//        weatherDataResponse.setMain(weatherDataMain);
//
//        Wind weatherDataWind = new Wind();
//        weatherDataWind.setSpeed(LOCATION_WIND_SPEED_1_34);
//        weatherDataResponse.setWind(weatherDataWind);
//
//        Sys weatherDataSys = new Sys();
//        weatherDataSys.setCountry(LOCATION_COUNTRY_CODE);
//        weatherDataResponse.setSys(weatherDataSys);
//
//        // when
//        LocationModel mergedLocationModel = openWeatherMapper.merge(locationModel, weatherDataResponse);
//
//        // then
//        assertAll(
//                () -> assertEquals(LOCATION_CITY_WARSZAWA, mergedLocationModel.getCity(), "mergedLocationModel CITY is not " + LOCATION_CITY_WARSZAWA),
//                () -> assertEquals(LOCATION_COUNTRY_CODE, mergedLocationModel.getCountryCode(), "mergedLocationModel COUNTRY CODE is not " + LOCATION_COUNTRY_CODE),
//                () -> assertEquals(LOCATION_LATITUDE_52_2298, mergedLocationModel.getLatitude(), "mergedLocationModel LATITUDE is not " + LOCATION_LATITUDE_52_2298),
//                () -> assertEquals(LOCATION_LONGITUDE_21_0118, mergedLocationModel.getLongitude(), "mergedLocationModel LONGITUDE is not " + LOCATION_LONGITUDE_21_0118)
//        );
//    }
}