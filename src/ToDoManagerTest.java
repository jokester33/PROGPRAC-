import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoManagerTest {
    private ToDoManager manager;

    @BeforeEach
    public void setUp() {
        manager = new ToDoManager();
    }

    @Test
    public void testAddToDoItem() {
        manager.addToDoItem("Test To-Do Item");
        assertEquals(1, manager.getItems().size());
        assertEquals("Test To-Do Item", manager.getItems().get(0).getDescription());
    }

    @Test
    public void testAddPriorityToDoItem() {
        manager.addPriorityToDoItem("Priority To-Do Item", 3);
        assertEquals(1, manager.getItems().size());
        assertTrue(manager.getItems().get(0) instanceof PriorityToDoItem);
        assertEquals("Priority To-Do Item", manager.getItems().get(0).getDescription());
        assertEquals(3, ((PriorityToDoItem) manager.getItems().get(0)).getPriority());
    }

    @Test
    public void testCompleteToDoItem() {
        manager.addToDoItem("Test To-Do Item");
        manager.completeToDoItem("Test To-Do Item");
        assertTrue(manager.getItems().get(0).isCompleted());
    }

    @Test
    public void testPrintToDoItems() {
        manager.addToDoItem("Test To-Do Item");
    }

    @Test
    public void testPrintToDoItemHistory() {
        manager.addToDoItem("Test To-Do Item");
        manager.completeToDoItem("Test To-Do Item");
    }
}
