package loginapp;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayManagerTest {

    @BeforeEach
    void setUp() {
        // Clear all static arrays using reflection (for repeatable tests)
        try {
            java.lang.reflect.Field[] fields = ArrayManager.class.getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                if (java.util.List.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    ((List<?>)field.get(null)).clear();
                }
            }
            // Reset task id
            java.lang.reflect.Field nextTaskIdField = ArrayManager.class.getDeclaredField("nextTaskId");
            nextTaskIdField.setAccessible(true);
            nextTaskIdField.setInt(null, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testAddTaskAndGetTasks() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        List<ArrayTask> tasks = ArrayManager.getTasks();
        assertEquals(2, tasks.size());
        assertEquals("Alice", tasks.get(0).getDeveloper());
        assertEquals("Bob", tasks.get(1).getDeveloper());
    }

    @Test
    void testGetTasksByStatus() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        ArrayManager.addTask("Carol", "Test App", 2, "Done");

        List<ArrayTask> doneTasks = ArrayManager.getTasksByStatus("Done");
        assertEquals(2, doneTasks.size());
        assertTrue(doneTasks.stream().anyMatch(t -> t.getDeveloper().equals("Bob")));
        assertTrue(doneTasks.stream().anyMatch(t -> t.getDeveloper().equals("Carol")));
    }

    @Test
    void testGetLongestDurationTask() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 10, "Doing");
        ArrayManager.addTask("Carol", "Test App", 2, "Done");
        ArrayTask longest = ArrayManager.getLongestDurationTask();
        assertNotNull(longest);
        assertEquals("Write Backend", longest.getTaskName());
        assertEquals(10, longest.getDuration());
    }

    @Test
    void testGetTasksByDeveloper() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        ArrayManager.addTask("Alice", "Write Docs", 3, "Doing");
        List<ArrayTask> aliceTasks = ArrayManager.getTasksByDeveloper("Alice");
        assertEquals(2, aliceTasks.size());
        assertTrue(aliceTasks.stream().anyMatch(t -> t.getTaskName().equals("Design UI")));
        assertTrue(aliceTasks.stream().anyMatch(t -> t.getTaskName().equals("Write Docs")));
    }

    @Test
    void testGetTaskByName() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        ArrayTask task = ArrayManager.getTaskByName("Design UI");
        assertNotNull(task);
        assertEquals("Alice", task.getDeveloper());
        assertNull(ArrayManager.getTaskByName("Nonexistent Task"));
    }

    @Test
    void testDeleteTaskByName() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        boolean deleted = ArrayManager.deleteTaskByName("Design UI");
        assertTrue(deleted);
        assertEquals(1, ArrayManager.getTasks().size());
        assertFalse(ArrayManager.deleteTaskByName("Nonexistent Task"));
    }

    @Test
    void testGetFullReport() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        String report = ArrayManager.getFullReport();
        assertTrue(report.contains("Developer: Alice"));
        assertTrue(report.contains("Developer: Bob"));
        assertTrue(report.startsWith("*** ALL TASKS REPORT ***"));
    }

    @Test
    void testGetDevelopersArray() {
        ArrayManager.addTask("Alice", "Design UI", 4, "To Do");
        ArrayManager.addTask("Bob", "Write Backend", 8, "Done");
        List<String> devs = ArrayManager.getDevelopersArray();
        assertTrue(devs.contains("Alice"));
        assertTrue(devs.contains("Bob"));
    }
}