package pl.juniorjavadeveloper.project.weatherman.utils;

import java.util.Scanner;
import java.util.logging.Logger;

public class CliUtils {
    private static final Logger LOGGER = Logger.getLogger(CliUtils.class.getName());

    public static String textInputWait(Scanner scanner, String message) {
        LOGGER.info("textInputWait()");

        System.out.println(message);

        String text;
        while ((text = scanner.nextLine()).equals("")) {
            System.out.println(message);
        }

        return text;
    }

    public static boolean booleanInputWait(Scanner scanner, String message) {
        LOGGER.info("booleanInputWait()");
        boolean status = false;

        String text;
        do {
            System.out.println(message);
            text = scanner.nextLine();
        } while (!(text).equalsIgnoreCase("Y")
                && !(text).equalsIgnoreCase("Yes")
                && !(text).equalsIgnoreCase("N")
                && !(text).equalsIgnoreCase("No"));

        if (text.equalsIgnoreCase("Y")) status = true;
        if (text.equalsIgnoreCase("Yes")) status = true;

        return status;
    }

    public static Long numberInputWait(Scanner scanner, String message) {
        LOGGER.info("numberInputWait(" + message + ", " + scanner + ")");
        boolean validInput;

        System.out.println(message);

        String text;
        do {
            text = scanner.nextLine();
            System.out.println(message);
            try {
                long parseLong = Long.parseLong(text);
                validInput = true;
                return parseLong;
            } catch (Exception e) {
                LOGGER.info("Invalid input " + e.getMessage());
                validInput = false;
            }
        } while (!validInput);

        return -1L;
    }
}
