import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static ExpenseManager expenseManager =
            new ExpenseManager();

    private static MealTracker mealTracker =
            new MealTracker();

    private static AssignmentManager assignmentManager =
            new AssignmentManager();

    private static TaskManager taskManager =
            new TaskManager();

    private static LaundryManager laundryManager =
            new LaundryManager();

    public static void main(String[] args) {

        createDataFiles();

        boolean running = true;

        while (running) {

            showMainMenu();

            int choice =
                    ValidationUtils.readInt(
                            scanner,
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:
                    expenseMenu();
                    break;

                case 2:
                    mealMenu();
                    break;

                case 3:
                    assignmentMenu();
                    break;

                case 4:
                    taskMenu();
                    break;

                case 5:
                    laundryMenu();
                    break;

                case 6:
                    showWeeklySummary();
                    break;

                case 7:

                    running = false;

                    System.out.println(
                            "\nThank you for using Hostel Life Manager!"
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice. Please select 1-7."
                    );
            }
        }

        scanner.close();
    }

    private static void createDataFiles() {

        FileManager.writeFile(
                "data/expenses.txt",
                FileManager.readFile("data/expenses.txt")
        );

        FileManager.writeFile(
                "data/meals.txt",
                FileManager.readFile("data/meals.txt")
        );

        FileManager.writeFile(
                "data/assignments.txt",
                FileManager.readFile("data/assignments.txt")
        );

        FileManager.writeFile(
                "data/tasks.txt",
                FileManager.readFile("data/tasks.txt")
        );

        FileManager.writeFile(
                "data/laundry.txt",
                FileManager.readFile("data/laundry.txt")
        );
    }

    private static void showMainMenu() {

        System.out.println();
        System.out.println(
                "╔══════════════════════════════════════╗"
        );

        System.out.println(
                "║          HOSTEL LIFE MANAGER         ║"
        );

        System.out.println(
                "╠══════════════════════════════════════╣"
        );

        System.out.println(
                "║ 1. Expense Tracker                   ║"
        );

        System.out.println(
                "║ 2. Mess Tracker                      ║"
        );

        System.out.println(
                "║ 3. Assignment Tracker                ║"
        );

        System.out.println(
                "║ 4. Daily Task Manager                ║"
        );

        System.out.println(
                "║ 5. Laundry Reminder                  ║"
        );

        System.out.println(
                "║ 6. Weekly Summary                    ║"
        );

        System.out.println(
                "║ 7. Exit                              ║"
        );

        System.out.println(
                "╚══════════════════════════════════════╝"
        );
    }

    // ================= EXPENSE MENU =================

    private static void expenseMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "========== EXPENSE TRACKER =========="
            );

            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Expense Summary");
            System.out.println("6. Back");

            int choice =
                    ValidationUtils.readInt(
                            scanner,
                            "Enter choice: "
                    );

            switch (choice) {

                case 1:

                    double amount =
                            ValidationUtils.readPositiveDouble(
                                    scanner,
                                    "Enter amount (₹): "
                            );

                    String category =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter category: "
                            );

                    String description =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter description: "
                            );

                    expenseManager.addExpense(
                            amount,
                            category,
                            description
                    );

                    break;

                case 2:

                    expenseManager.viewExpenses();

                    break;

                case 3:

                    int updateId =
                            ValidationUtils.readInt(
                                    scanner,
                                    "Enter expense ID: "
                            );

                    double updateAmount =
                            ValidationUtils.readPositiveDouble(
                                    scanner,
                                    "Enter new amount: "
                            );

                    String updateCategory =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter new category: "
                            );

                    String updateDescription =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter new description: "
                            );

                    expenseManager.updateExpense(
                            updateId,
                            updateAmount,
                            updateCategory,
                            updateDescription
                    );

                    break;

                case 4:

                    int deleteId =
                            ValidationUtils.readInt(
                                    scanner,
                                    "Enter expense ID: "
                            );

                    expenseManager.deleteExpense(deleteId);

                    break;

                case 5:

                    System.out.println(
                            "\nTotal spending: ₹" +
                            String.format(
                                    "%.2f",
                                    expenseManager.getTotalExpense()
                            )
                    );

                    System.out.println(
                            "Highest spending category: " +
                            expenseManager.getHighestCategory()
                    );

                    System.out.println(
                            "Small expenses (< ₹100): ₹" +
                            String.format(
                                    "%.2f",
                                    expenseManager.getSmallExpenses()
                            )
                    );

                    break;

                case 6:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ================= MEAL MENU =================

    private static void mealMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "========== MESS TRACKER =========="
            );

            System.out.println("1. Record Today's Meals");
            System.out.println("2. View Today's Meals");
            System.out.println("3. Meal Statistics");
            System.out.println("4. Back");

            int choice =
                    ValidationUtils.readInt(
                            scanner,
                            "Enter choice: "
                    );

            switch (choice) {

                case 1:

                    String breakfast =
                            ValidationUtils.readMealStatus(
                                    scanner,
                                    "Breakfast"
                            );

                    String lunch =
                            ValidationUtils.readMealStatus(
                                    scanner,
                                    "Lunch"
                            );

                    String dinner =
                            ValidationUtils.readMealStatus(
                                    scanner,
                                    "Dinner"
                            );

                    mealTracker.recordToday(
                            breakfast,
                            lunch,
                            dinner
                    );

                    break;

                case 2:

                    mealTracker.showToday();

                    break;

                case 3:

                    mealTracker.showStatistics();

                    break;

                case 4:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ================= ASSIGNMENT MENU =================

    private static void assignmentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "========== ASSIGNMENT TRACKER =========="
            );

            System.out.println("1. Add Assignment");
            System.out.println("2. View Assignments");
            System.out.println("3. Mark Completed");
            System.out.println("4. Delete Assignment");
            System.out.println("5. Back");

            int choice =
                    ValidationUtils.readInt(
                            scanner,
                            "Enter choice: "
                    );

            switch (choice) {

                case 1:

                    String subject =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter subject: "
                            );

                    String title =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter assignment title: "
                            );

                    String deadline =
                            ValidationUtils.readDate(
                                    scanner,
                                    "Enter deadline (YYYY-MM-DD): "
                            );

                    assignmentManager.addAssignment(
                            subject,
                            title,
                            deadline
                    );

                    break;

                case 2:

                    assignmentManager.viewAssignments();

                    break;

                case 3:

                    int id =
                            ValidationUtils.readInt(
                                    scanner,
                                    "Enter assignment ID: "
                            );

                    assignmentManager.markCompleted(id);

                    break;

                case 4:

                    int deleteId =
                            ValidationUtils.readInt(
                                    scanner,
                                    "Enter assignment ID: "
                            );

                    assignmentManager.deleteAssignment(deleteId);

                    break;

                case 5:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ================= TASK MENU =================

    private static void taskMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "========== DAILY TASK MANAGER =========="
            );

            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Back");

            int choice =
                    ValidationUtils.readInt(
                            scanner,
                            "Enter choice: "
                    );

            switch (choice) {

                case 1:

                    String description =
                            ValidationUtils.readNonEmpty(
                                    scanner,
                                    "Enter task: "
                            );

                    taskManager.addTask(description);

                    break;

                case 2:

                    taskManager.viewTasks();

                    break;

                case 3:

                    int id =
                            ValidationUtils.readInt(
                                    scanner,
                                    "Enter task ID: "
                            );

                    taskManager.completeTask(id);

                    break;

                case 4:

                    int deleteId =
                            ValidationUtils.readInt(
                                    scanner,
                                    "Enter task ID: "
                            );

                    taskManager.deleteTask(deleteId);

                    break;

                case 5:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ================= LAUNDRY MENU =================

    private static void laundryMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "========== LAUNDRY REMINDER =========="
            );

            System.out.println("1. Record Laundry Today");
            System.out.println("2. Check Laundry Status");
            System.out.println("3. Back");

            int choice =
                    ValidationUtils.readInt(
                            scanner,
                            "Enter choice: "
                    );

            switch (choice) {

                case 1:

                    laundryManager.recordLaundry();

                    break;

                case 2:

                    laundryManager.showStatus();

                    break;

                case 3:

                    back = true;

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ================= SUMMARY =================

    private static void showWeeklySummary() {

        System.out.println();
        System.out.println(
                "========================================"
        );

        System.out.println(
                "          HOSTEL WEEK SUMMARY"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "Meals eaten          : " +
                mealTracker.getTotalEaten()
        );

        System.out.println(
                "Meals skipped        : " +
                mealTracker.getTotalSkipped()
        );

        System.out.println(
                "Total money spent    : ₹" +
                String.format(
                        "%.2f",
                        expenseManager.getTotalExpense()
                )
        );

        System.out.println(
                "Highest expense      : " +
                expenseManager.getHighestCategory()
        );

        System.out.println(
                "Pending assignments  : " +
                assignmentManager.getPendingCount()
        );

        System.out.println(
                "Next deadline        : " +
                assignmentManager.getNextDeadline()
        );

        System.out.println(
                "Pending tasks        : " +
                taskManager.getPendingCount()
        );

        System.out.println(
                "Laundry status       : " +
                laundryManager.getStatus()
        );

        System.out.println(
                "========================================"
        );
    }
}