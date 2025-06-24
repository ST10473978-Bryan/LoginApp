package loginapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskTest {

    @Test
    void testConstructorAndGetters() {
        ArrayTask task = new ArrayTask("Alice Johnson", "Write Tests", "T10", 7, "Doing");

        assertEquals("Alice Johnson", task.getDeveloper());
        assertEquals("Write Tests", task.getTaskName());
        assertEquals("T10", task.getTaskID());
        assertEquals(7, task.getDuration());
        assertEquals("Doing", task.getStatus());
    }

    @Test
    void testSetters() {
        ArrayTask task = new ArrayTask("Bob", "Setup DB", "T5", 3, "To Do");

        task.setDeveloper("Charlie");
        task.setTaskName("Configure Server");
        task.setTaskID("T20");
        task.setDuration(12);
        task.setStatus("Done");

        assertEquals("Charlie", task.getDeveloper());
        assertEquals("Configure Server", task.getTaskName());
        assertEquals("T20", task.getTaskID());
        assertEquals(12, task.getDuration());
        assertEquals("Done", task.getStatus());
    }

    @Test
    void testToString() {
        ArrayTask task = new ArrayTask("Dana", "Review Code", "T3", 5, "Done");
        String expected = "Developer: Dana\nTask Name: Review Code\nTask ID: T3\nTask Duration: 5\nTask Status: Done\n";
        assertEquals(expected, task.toString());
    }
}