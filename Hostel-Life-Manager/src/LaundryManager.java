import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LaundryManager {

    private LocalDate lastLaundryDate;
    private final int LAUNDRY_INTERVAL = 7;

    public LaundryManager() {

        loadLaundry();
    }

    private void loadLaundry() {

        ArrayList<String> lines =
                FileManager.readFile("data/laundry.txt");

        if (!lines.isEmpty()) {

            try {
                lastLaundryDate =
                        LocalDate.parse(lines.get(0));
            } catch (Exception e) {
                lastLaundryDate = null;
            }
        }
    }

    private void saveLaundry() {

        ArrayList<String> lines = new ArrayList<>();

        if (lastLaundryDate != null) {
            lines.add(lastLaundryDate.toString());
        }

        FileManager.writeFile("data/laundry.txt", lines);
    }

    public void recordLaundry() {

        lastLaundryDate = LocalDate.now();

        saveLaundry();

        System.out.println("\nLaundry date recorded successfully.");
    }

    public void showStatus() {

        if (lastLaundryDate == null) {

            System.out.println("\nNo laundry record found.");
            return;
        }

        long days =
                ChronoUnit.DAYS.between(
                        lastLaundryDate,
                        LocalDate.now()
                );

        long remaining =
                LAUNDRY_INTERVAL - days;

        System.out.println("\n========== LAUNDRY STATUS ==========");

        System.out.println(
                "Last laundry: " + lastLaundryDate
        );

        if (remaining > 0) {

            System.out.println(
                    "Laundry due in " + remaining + " day(s)."
            );

        } else if (remaining == 0) {

            System.out.println(
                    "Laundry is due TODAY!"
            );

        } else {

            System.out.println(
                    "Laundry is overdue by " + (-remaining) + " day(s)!"
            );
        }
    }

    public String getStatus() {

        if (lastLaundryDate == null) {
            return "No record";
        }

        long days =
                ChronoUnit.DAYS.between(
                        lastLaundryDate,
                        LocalDate.now()
                );

        long remaining =
                LAUNDRY_INTERVAL - days;

        if (remaining > 0) {
            return "Due in " + remaining + " day(s)";
        }

        if (remaining == 0) {
            return "Due today";
        }

        return "Overdue by " + (-remaining) + " day(s)";
    }
}
