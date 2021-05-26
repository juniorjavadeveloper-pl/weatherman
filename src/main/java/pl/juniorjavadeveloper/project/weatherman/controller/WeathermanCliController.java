package pl.juniorjavadeveloper.project.weatherman.controller;

import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanService;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class WeathermanCliController {
    private static final Logger LOGGER = Logger.getLogger(WeathermanCliController.class.getName());

    private final Scanner scanner;
    private final WeathermanService weathermanService;

    public static final String CLI_GLOBAL_CHOOSE_ACTION_INFO_TEXT =
            "Choose action:\n" +
                    "1 - List Locations\n" +
                    "2 - Add Location\n" +
                    "3 - Get Location Weather\n" +
                    "q - Quit App\n";

    public WeathermanCliController(Scanner scanner, WeathermanService weathermanService) {
        this.scanner = scanner;
        this.weathermanService = weathermanService;
    }

    public void mainCLiLoop() {
        System.out.println("Welcome in the Weatherman App!");
        System.out.println(CLI_GLOBAL_CHOOSE_ACTION_INFO_TEXT);

        String text;
        while (!(text = scanner.nextLine()).equals("q")) {

            int chosenAction = -1;
            try {
                chosenAction = Integer.parseInt(text);
            } catch (Exception e) {
                LOGGER.info("Invalid input " + e.getMessage());
            }

            switch (chosenAction) {
                case 1: {
                    // add location
                    System.out.println("Adding new Location:");
                    weathermanService.create(new LocationModel());
                    break;
                }
                case 2: {
                    // list locations
                    List<LocationModel> locations = weathermanService.list();
                    System.out.println("All Locations:");
                    locations.forEach(System.out::println);
                    break;
                }
                case 3: {
                    // get location weather
                    LocationModel locationWeatherData = weathermanService.read(1L);
                    System.out.println("Location Weather Data:");
                    System.out.println(locationWeatherData);
                    break;
                }
                default: {
                    break;
                }
            }

            System.out.println(CLI_GLOBAL_CHOOSE_ACTION_INFO_TEXT);
        }

        System.out.println("Good bye!");
    }
}
