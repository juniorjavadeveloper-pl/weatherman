package pl.juniorjavadeveloper.project.weatherman;

import pl.juniorjavadeveloper.project.weatherman.controller.WeathermanCliController;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.external.api.openweather.service.OpenWeatherApiCurrentWeatherDataService;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanManagerService;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanService;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.LocationMapper;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.OpenWeatherMapper;

import java.util.Scanner;

public class WeathermanApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocationMapper locationMapper = new LocationMapper();
        OpenWeatherMapper openWeatherMapper = new OpenWeatherMapper();

        HibernateWeathermanDao hibernateWeathermanDao = new HibernateWeathermanDao();
        OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService = new OpenWeatherApiCurrentWeatherDataService();

        WeathermanService weathermanService = new WeathermanService(hibernateWeathermanDao, locationMapper);
        WeathermanManagerService weathermanManagerService = new WeathermanManagerService(
                weathermanService, openWeatherApiCurrentWeatherDataService, openWeatherMapper);
        WeathermanCliController weathermanCliController = new WeathermanCliController(scanner, weathermanManagerService);
        weathermanCliController.mainCLiLoop();
    }
}
