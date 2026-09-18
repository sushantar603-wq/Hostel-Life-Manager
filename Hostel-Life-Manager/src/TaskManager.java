import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {

        tasks = new ArrayList<>();
        loadTasks();
    }

    private void loadTasks() {

        ArrayList<String> lines =
                FileManager.readFile("data/tasks.txt");

        for (String line : lines) {

            try {

                String[] parts = line.split("\\|");

                if (parts.length == 3) {

                    tasks.add(
                            new Task(
                                    Integer.parseInt(parts[0]),
                                    parts[1],
                                    Boolean.parseBoolean(parts[2])
                            )
                    );
                }

            } catch (Exception e) {
                System.out.println("Could not load task.");
            }
        }
    }

    private void saveTasks() {

        ArrayList<String> lines = new ArrayList<>();

        for (Task task : tasks) {
            lines.add(task.toFileString());
        }

        FileManager.writeFile("data/tasks.txt", lines);
    }

    private int getNextId() {

        int max = 0;

        for (Task task : tasks) {

            if (task.getId() > max) {
                max = task.getId();
            }
        }

        return max + 1;
    }

    public void addTask(String description) {

        tasks.add(
                new Task(
                        getNextId(),
                        description,
                        false
                )
        );

        saveTasks();

        System.out.println("\nTask added successfully.");
    }

    public void viewTasks() {

        if (tasks.isEmpty()) {

            System.out.println("\nNo tasks found.");
            return;
        }

        System.out.println("\n========== DAILY TASKS ==========");

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {

                task.setCompleted(true);
                saveTasks();

                System.out.println("\nTask completed.");
                return;
            }
        }

        System.out.println("\nTask ID not found.");
    }

    public void deleteTask(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {

                tasks.remove(task);
                saveTasks();

                System.out.println("\nTask deleted.");
                return;
            }
        }

        System.out.println("\nTask ID not found.");
    }

    public int getPendingCount() {

        int count = 0;

        for (Task task : tasks) {

            if (!task.isCompleted()) {
                count++;
            }
        }

        return count;
    }
}