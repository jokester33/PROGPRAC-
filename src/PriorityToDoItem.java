public class PriorityToDoItem extends ToDoItem {
    private int priority;

    public PriorityToDoItem(String description, int priority) {
        super(description);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + " (Priority: " + priority + ")";
    }
}

