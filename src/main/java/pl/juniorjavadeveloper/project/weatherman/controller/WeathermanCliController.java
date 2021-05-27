package pl.juniorjavadeveloper.project.weatherman.controller;

import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;
import pl.juniorjavadeveloper.project.weatherman.model.WeatherDataRequestModel;
import pl.juniorjavadeveloper.project.weatherman.service.WeathermanManagerService;
import pl.juniorjavadeveloper.project.weatherman.utils.CliUtils;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class WeathermanCliController {
    private static final Logger LOGGER = Logger.getLogger(WeathermanCliController.class.getName());

    private final Scanner scanner;
    private final WeathermanManagerService weathermanManagerService;

    public static final String CLI_GLOBAL_CHOOSE_ACTION_INFO_TEXT =
            "Choose action:\n" +
                    "1 - List Locations\n" +
                    "2 - Add Location\n" +
                    "3 - Get Location Weather\n" +
                    "q - Quit App\n";

    public WeathermanCliController(Scanner scanner, WeathermanManagerService weathermanManagerService) {
        this.scanner = scanner;
        this.weathermanManagerService = weathermanManagerService;
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
                    // list locations
                    List<LocationModel> locations = weathermanManagerService.list();
                    System.out.println("All Locations:");
                    locations.forEach(System.out::println);
                    break;
                }
                case 2: {
                    // add location
                    System.out.println("Adding new Location:");

                    String city = CliUtils.textInputWait(scanner, "Enter City name (e.g.: Warsaw):");
                    String countryCode = CliUtils.textInputWait(scanner, "Enter Country Code (e.g.: PL):");;
                    WeatherDataRequestModel weatherDataRequestModel = new WeatherDataRequestModel(city, countryCode);

                    LocationModel locationModel = weathermanManagerService.create(weatherDataRequestModel);
                    System.out.println("Added Location data:");
                    System.out.println(locationModel);
                    break;
                }
                case 3: {
                    // get location weather
//                    String locationId = CliUtils.textInputWait(scanner, "Enter Location ID (TIP: Use Command \"1 - List Locations\" ):");
                    Long locationId = CliUtils.numberInputWait(scanner, "Enter Location ID (TIP: Use Command \"1 - List Locations\" ):");

                    LocationModel locationWeatherData = weathermanManagerService.read(locationId);
                    System.out.println("Location Weather Data:");
                    System.out.println(locationWeatherData);
                    break;
                }
                default: {
                    System.out.println("Unknown Action!");
                    break;
                }
            }

            System.out.println(CLI_GLOBAL_CHOOSE_ACTION_INFO_TEXT);
        }

        System.out.println("Good bye!");
    }
}
