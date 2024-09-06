import java.util.ArrayList;

public class ToDoItem {
    private String description;
    private boolean isCompleted;
    private ArrayList<String> statusHistory;

    public ToDoItem(String description) {
        this.description = description;
        this.isCompleted = false;
        this.statusHistory = new ArrayList<>();
        statusHistory.add("Created");
    }

    public void markCompleted() {
        if (!isCompleted) {
            isCompleted = true;
            statusHistory.add("Completed");
        }
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void printStatusHistory() {
        System.out.println("Status history for \"" + description + "\":");
        for (String status : statusHistory) {
            System.out.println("  " + status);
        }
    }

    public String displayDetails() {
        return (isCompleted ? "[Done]" : "[Not Done]") + " " + description;
    }
}
