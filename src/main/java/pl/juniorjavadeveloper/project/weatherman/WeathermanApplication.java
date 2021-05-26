package pl.juniorjavadeveloper.project.weatherman;

import pl.juniorjavadeveloper.project.weatherman.controller.WeathermanCliController;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanService;

import java.util.Scanner;

public class WeathermanApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeathermanService weathermanService = new WeathermanService();

        WeathermanCliController weathermanCliController = new WeathermanCliController(scanner, weathermanService);
        weathermanCliController.mainCLiLoop();
    }
}
