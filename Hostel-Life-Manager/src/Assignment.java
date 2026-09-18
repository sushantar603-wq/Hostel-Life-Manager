public class Assignment {

    private int id;
    private String subject;
    private String title;
    private String deadline;
    private boolean completed;

    public Assignment(
            int id,
            String subject,
            String title,
            String deadline,
            boolean completed
    ) {
        this.id = id;
        this.subject = subject;
        this.title = title;
        this.deadline = deadline;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String toFileString() {

        return id + "|" +
                subject + "|" +
                title + "|" +
                deadline + "|" +
                completed;
    }

    @Override
    public String toString() {

        return "ID: " + id +
                " | Subject: " + subject +
                " | Assignment: " + title +
                " | Deadline: " + deadline +
                " | Status: " +
                (completed ? "Completed" : "Pending");
    }
}
