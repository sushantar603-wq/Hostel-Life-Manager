import java.time.LocalDate;
import java.util.ArrayList;

public class MealTracker {

    private ArrayList<Meal> meals;

    public MealTracker() {
        meals = new ArrayList<>();
        loadMeals();
    }

    private void loadMeals() {

        ArrayList<String> lines = FileManager.readFile("data/meals.txt");

        for (String line : lines) {

            try {

                String[] parts = line.split("\\|");

                if (parts.length == 4) {

                    meals.add(
                            new Meal(
                                    parts[0],
                                    parts[1],
                                    parts[2],
                                    parts[3]
                            )
                    );
                }

            } catch (Exception e) {
                System.out.println("Could not load meal record.");
            }
        }
    }

    private void saveMeals() {

        ArrayList<String> lines = new ArrayList<>();

        for (Meal meal : meals) {
            lines.add(meal.toFileString());
        }

        FileManager.writeFile("data/meals.txt", lines);
    }

    public void recordToday(String breakfast, String lunch, String dinner) {

        String today = LocalDate.now().toString();

        Meal existingMeal = null;

        for (Meal meal : meals) {

            if (meal.getDate().equals(today)) {
                existingMeal = meal;
                break;
            }
        }

        if (existingMeal != null) {
            meals.remove(existingMeal);
        }

        meals.add(
                new Meal(
                        today,
                        breakfast,
                        lunch,
                        dinner
                )
        );

        saveMeals();

        System.out.println("\nToday's meals have been recorded.");
    }

    public void showToday() {

        String today = LocalDate.now().toString();

        for (Meal meal : meals) {

            if (meal.getDate().equals(today)) {

                System.out.println("\n========== TODAY'S MEALS ==========");
                System.out.println(meal);

                System.out.println(
                        "Meals eaten: " + meal.getEatenCount() + "/3"
                );

                System.out.println(
                        "Meals skipped: " + meal.getSkippedCount()
                );

                return;
            }
        }

        System.out.println("\nNo meal record found for today.");
    }

    public int getTotalEaten() {

        int total = 0;

        for (Meal meal : meals) {
            total += meal.getEatenCount();
        }

        return total;
    }

    public int getTotalSkipped() {

        int total = 0;

        for (Meal meal : meals) {
            total += meal.getSkippedCount();
        }

        return total;
    }

    public void showStatistics() {

        System.out.println("\n========== MEAL STATISTICS ==========");
        System.out.println("Meals eaten   : " + getTotalEaten());
        System.out.println("Meals skipped : " + getTotalSkipped());
    }
}