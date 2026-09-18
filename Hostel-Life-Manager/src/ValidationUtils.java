import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidationUtils {

    public static double readPositiveDouble(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                double value = Double.parseDouble(input);

                if (value > 0) {
                    return value;
                }

                System.out.println(
                        "Amount must be greater than zero."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    public static int readInt(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    public static String readNonEmpty(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "This field cannot be empty."
            );
        }
    }

    public static String readDate(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                LocalDate.parse(input);

                return input;

            } catch (DateTimeParseException e) {

                System.out.println(
                        "Invalid date. Use YYYY-MM-DD."
                );
            }
        }
    }

    public static String readMealStatus(
            Scanner scanner,
            String mealName
    ) {

        while (true) {

            System.out.print(
                    mealName + " (Ate/Skipped): "
            );

            String input =
                    scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Ate")) {
                return "Ate";
            }

            if (input.equalsIgnoreCase("Skipped")) {
                return "Skipped";
            }

            System.out.println(
                    "Please enter Ate or Skipped."
            );
        }
    }
}
