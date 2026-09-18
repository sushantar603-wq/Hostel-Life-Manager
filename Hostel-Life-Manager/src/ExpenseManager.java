import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpenses();
    }

    private void loadExpenses() {
        ArrayList<String> lines = FileManager.readFile("data/expenses.txt");

        for (String line : lines) {
            try {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String category = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String description = parts[3];
                    String date = parts[4];

                    expenses.add(
                            new Expense(id, category, amount, description, date)
                    );
                }
            } catch (Exception e) {
                System.out.println("Could not load an expense record.");
            }
        }
    }

    private void saveExpenses() {
        ArrayList<String> lines = new ArrayList<>();

        for (Expense expense : expenses) {
            lines.add(expense.toFileString());
        }

        FileManager.writeFile("data/expenses.txt", lines);
    }

    private int getNextId() {
        int maxId = 0;

        for (Expense expense : expenses) {
            if (expense.getId() > maxId) {
                maxId = expense.getId();
            }
        }

        return maxId + 1;
    }

    public void addExpense(double amount, String category, String description) {

        int id = getNextId();
        String date = LocalDate.now().toString();

        Expense expense = new Expense(
                id,
                category,
                amount,
                description,
                date
        );

        expenses.add(expense);
        saveExpenses();

        System.out.println("\nExpense added successfully!");
    }

    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses found.");
            return;
        }

        System.out.println("\n========== ALL EXPENSES ==========");

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void updateExpense(int id, double amount, String category, String description) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expense.setAmount(amount);
                expense.setCategory(category);
                expense.setDescription(description);

                saveExpenses();

                System.out.println("\nExpense updated successfully!");
                return;
            }
        }

        System.out.println("\nExpense ID not found.");
    }

    public void deleteExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expenses.remove(expense);
                saveExpenses();

                System.out.println("\nExpense deleted successfully!");
                return;
            }
        }

        System.out.println("\nExpense ID not found.");
    }

    public double getTotalExpense() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public String getHighestCategory() {

        if (expenses.isEmpty()) {
            return "No expenses";
        }

        String highestCategory = "";
        double highestAmount = 0;

        ArrayList<String> categories = new ArrayList<>();

        for (Expense expense : expenses) {

            if (!categories.contains(expense.getCategory())) {
                categories.add(expense.getCategory());
            }
        }

        for (String category : categories) {

            double categoryTotal = 0;

            for (Expense expense : expenses) {

                if (expense.getCategory().equalsIgnoreCase(category)) {
                    categoryTotal += expense.getAmount();
                }
            }

            if (categoryTotal > highestAmount) {
                highestAmount = categoryTotal;
                highestCategory = category;
            }
        }

        return highestCategory;
    }

    public double getSmallExpenses() {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.getAmount() < 100) {
                total += expense.getAmount();
            }
        }

        return total;
    }

    public int getExpenseCount() {
        return expenses.size();
    }
}
      