public class Meal {

    private String date;
    private String breakfast;
    private String lunch;
    private String dinner;

    public Meal(String date, String breakfast, String lunch, String dinner) {
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getDate() {
        return date;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public String toFileString() {
        return date + "|" + breakfast + "|" + lunch + "|" + dinner;
    }

    public int getEatenCount() {

        int count = 0;

        if (breakfast.equalsIgnoreCase("Ate")) {
            count++;
        }

        if (lunch.equalsIgnoreCase("Ate")) {
            count++;
        }

        if (dinner.equalsIgnoreCase("Ate")) {
            count++;
        }

        return count;
    }

    public int getSkippedCount() {
        return 3 - getEatenCount();
    }

    @Override
    public String toString() {

        return "Date: " + date +
                " | Breakfast: " + breakfast +
                " | Lunch: " + lunch +
                " | Dinner: " + dinner;
    }
}
