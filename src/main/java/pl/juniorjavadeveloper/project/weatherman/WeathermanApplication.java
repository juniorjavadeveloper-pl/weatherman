package pl.juniorjavadeveloper.project.weatherman;

import pl.juniorjavadeveloper.project.weatherman.controller.WeathermanCliController;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.HibernateWeathermanDao;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanService;

import java.util.Scanner;

public class WeathermanApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HibernateWeathermanDao hibernateWeathermanDao = new HibernateWeathermanDao();
        WeathermanService weathermanService = new WeathermanService(hibernateWeathermanDao);

        WeathermanCliController weathermanCliController = new WeathermanCliController(scanner, weathermanService);
        weathermanCliController.mainCLiLoop();
    }
}
