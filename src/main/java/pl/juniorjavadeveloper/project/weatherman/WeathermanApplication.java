package pl.juniorjavadeveloper.project.weatherman;

import pl.juniorjavadeveloper.project.weatherman.controller.WeathermanCliController;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanService;
import pl.juniorjavadeveloper.project.weatherman.service.mapper.LocationMapper;

import java.util.Scanner;

public class WeathermanApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HibernateWeathermanDao hibernateWeathermanDao = new HibernateWeathermanDao();
        LocationMapper locationMapper = new LocationMapper();

        WeathermanService weathermanService = new WeathermanService(hibernateWeathermanDao, locationMapper);
        WeathermanCliController weathermanCliController = new WeathermanCliController(scanner, weathermanService);
        weathermanCliController.mainCLiLoop();
    }
}
