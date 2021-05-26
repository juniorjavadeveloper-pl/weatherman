package pl.juniorjavadeveloper.project.weatherman.controller;

import java.util.Scanner;
import java.util.logging.Logger;

public class WeathermanCliController {
    private static final Logger LOGGER = Logger.getLogger(WeathermanCliController.class.getName());

    private final Scanner scanner;

    public static final String CLI_GLOBAL_CHOOSE_ACTION_INFO_TEXT =
            "Choose action:\n" +
                    "1 - Add Location\n" +
                    "2 - List Locations\n" +
                    "3 - Get Location Weather\n" +
                    "q - Quit App\n";

    public WeathermanCliController(Scanner scanner) {
        this.scanner = scanner;
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
                    break;
                }
                case 2: {
                    // list locations
                    break;
                }
                case 3: {
                    // get location weather
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
