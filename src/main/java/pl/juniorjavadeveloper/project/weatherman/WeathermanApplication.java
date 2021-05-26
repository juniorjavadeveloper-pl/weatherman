package pl.juniorjavadeveloper.project.weatherman;

import pl.juniorjavadeveloper.project.weatherman.controller.WeathermanCliController;

import java.util.Scanner;

public class WeathermanApplication {
    public static void main(String[] args) {
        WeathermanCliController weathermanCliController = new WeathermanCliController(new Scanner(System.in));
        weathermanCliController.mainCLiLoop();
    }
}
