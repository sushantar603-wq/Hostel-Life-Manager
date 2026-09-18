import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AssignmentManager {

    private ArrayList<Assignment> assignments;

    public AssignmentManager() {

        assignments = new ArrayList<>();
        loadAssignments();
    }

    private void loadAssignments() {

        ArrayList<String> lines =
                FileManager.readFile("data/assignments.txt");

        for (String line : lines) {

            try {

                String[] parts = line.split("\\|");

                if (parts.length == 5) {

                    assignments.add(
                            new Assignment(
                                    Integer.parseInt(parts[0]),
                                    parts[1],
                                    parts[2],
                                    parts[3],
                                    Boolean.parseBoolean(parts[4])
                            )
                    );
                }

            } catch (Exception e) {
                System.out.println("Could not load assignment.");
            }
        }
    }

    private void saveAssignments() {

        ArrayList<String> lines = new ArrayList<>();

        for (Assignment assignment : assignments) {
            lines.add(assignment.toFileString());
        }

        FileManager.writeFile("data/assignments.txt", lines);
    }

    private int getNextId() {

        int max = 0;

        for (Assignment assignment : assignments) {

            if (assignment.getId() > max) {
                max = assignment.getId();
            }
        }

        return max + 1;
    }

    public void addAssignment(
            String subject,
            String title,
            String deadline
    ) {

        int id = getNextId();

        assignments.add(
                new Assignment(
                        id,
                        subject,
                        title,
                        deadline,
                        false
                )
        );

        saveAssignments();

        System.out.println("\nAssignment added successfully.");
    }

    public void viewAssignments() {

        if (assignments.isEmpty()) {
            System.out.println("\nNo assignments found.");
            return;
        }

        System.out.println("\n========== ASSIGNMENTS ==========");

        for (Assignment assignment : assignments) {

            System.out.println(assignment);

            try {

                LocalDate deadline =
                        LocalDate.parse(assignment.getDeadline());

                long days =
                        java.time.temporal.ChronoUnit.DAYS.between(
                                LocalDate.now(),
                                deadline
                        );

                if (!assignment.isCompleted()) {

                    if (days < 0) {
                        System.out.println("   OVERDUE by " + (-days) + " day(s)");
                    } else if (days == 0) {
                        System.out.println("   Due TODAY!");
                    } else {
                        System.out.println("   Due in " + days + " day(s)");
                    }
                }

            } catch (Exception e) {
                System.out.println("   Invalid deadline format.");
            }

            System.out.println();
        }
    }

    public void markCompleted(int id) {

        for (Assignment assignment : assignments) {

            if (assignment.getId() == id) {

                assignment.setCompleted(true);
                saveAssignments();

                System.out.println("\nAssignment marked as completed.");
                return;
            }
        }

        System.out.println("\nAssignment ID not found.");
    }

    public void deleteAssignment(int id) {

        for (Assignment assignment : assignments) {

            if (assignment.getId() == id) {

                assignments.remove(assignment);
                saveAssignments();

                System.out.println("\nAssignment deleted.");
                return;
            }
        }

        System.out.println("\nAssignment ID not found.");
    }

    public int getPendingCount() {

        int count = 0;

        for (Assignment assignment : assignments) {

            if (!assignment.isCompleted()) {
                count++;
            }
        }

        return count;
    }

    public String getNextDeadline() {

        LocalDate nearest = null;
        String title = "None";

        for (Assignment assignment : assignments) {

            if (!assignment.isCompleted()) {

                try {

                    LocalDate deadline =
                            LocalDate.parse(assignment.getDeadline());

                    if (nearest == null || deadline.isBefore(nearest)) {

                        nearest = deadline;
                        title = assignment.getTitle();
                    }

                } catch (Exception e) {
                    // Ignore invalid dates.
                }
            }
        }

        if (nearest == null) {
            return "None";
        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return title + " (" + nearest.format(formatter) + ")";
    }
}
