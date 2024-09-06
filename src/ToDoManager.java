import java.util.ArrayList;
import java.util.Scanner;

public class ToDoManager {
    private ArrayList<ToDoItem> items;
    private Scanner scanner;

    public ToDoManager() {
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addToDoItem(String description) {
        items.add(new ToDoItem(description));
        System.out.println("To-Do item added.");
    }

    public void addPriorityToDoItem(String description, int priority) {
        items.add(new PriorityToDoItem(description, priority));
        System.out.println("Priority To-Do item added.");
    }

    public void completeToDoItem(String description) {
        for (ToDoItem item : items) {
            if (item.getDescription().equalsIgnoreCase(description)) {
                item.markCompleted();
                System.out.println("To-Do item marked as completed.");
                return;
            }
        }
        System.out.println("To-Do item not found.");
    }

    public void printToDoItems() {
        System.out.println("To-Do Report:");
        System.out.println("==============");
        for (ToDoItem item : items) {
            System.out.println(item.displayDetails());
        }
        System.out.println("==============");
    }

    public void printToDoItemHistory(String description) {
        for (ToDoItem item : items) {
            if (item.getDescription().equalsIgnoreCase(description)) {
                item.printStatusHistory();
                return;
            }
        }
        System.out.println("To-Do item not found.");
    }

    public void run() {
        while (true) {
            System.out.println("1. Add To-Do Item");
            System.out.println("2. Add Priority To-Do Item");
            System.out.println("3. Complete To-Do Item");
            System.out.println("4. Print All To-Do Items");
            System.out.println("5. Print To-Do Item History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter to-do item description: ");
                    addToDoItem(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter to-do item description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter priority (1-5): ");
                    int priority = Integer.parseInt(scanner.nextLine());
                    addPriorityToDoItem(desc, priority);
                    break;
                case 3:
                    System.out.print("Enter to-do item description to complete: ");
                    completeToDoItem(scanner.nextLine());
                    break;
                case 4:
                    printToDoItems();
                    break;
                case 5:
                    System.out.print("Enter to-do item description to view history: ");
                    printToDoItemHistory(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public ArrayList<ToDoItem> getItems() {
        return items;
    }
}

