package loginapp;

import java.util.*;

public class ArrayManager {
    // Arrays as per requirements
    private static ArrayList<String> developers = new ArrayList<>();
    private static ArrayList<String> taskNames = new ArrayList<>();
    private static ArrayList<String> taskIDs = new ArrayList<>();
    private static ArrayList<Integer> taskDurations = new ArrayList<>();
    private static ArrayList<String> taskStatuses = new ArrayList<>();
    private static ArrayList<ArrayTask> tasks = new ArrayList<>();

    // Used for generating unique task IDs
    private static int nextTaskId = 1;

    // Populate with test data
    static {
        addTask("Mike Smith", "Create Login", 5, "To Do");
        addTask("Edward Harrison", "Create Add Features", 6, "Doing");
        addTask("Samantha Paulson", "Create Reports", 2, "Done");
        addTask("Glenda Oberholzer", "Add Arrays", 11, "To Do");
        addTask("Diego de vannoci", "Add Arrays", 12, "To Do");
    }

    public static void addTask(String developer, String taskName, int duration, String status) {
        String taskID = "T" + nextTaskId++;
        ArrayTask t = new ArrayTask(developer, taskName, taskID, duration, status);
        developers.add(developer);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(duration);
        taskStatuses.add(status);
        tasks.add(t);
    }

    // For use in the UI
    public static ArrayList<ArrayTask> getTasks() {
        return new ArrayList<>(tasks);
    }

    public static ArrayList<ArrayTask> getTasksByStatus(String status) {
        ArrayList<ArrayTask> result = new ArrayList<>();
        for (ArrayTask t : tasks) {
            if (t.getStatus().equalsIgnoreCase(status)) result.add(t);
        }
        return result;
    }

    public static ArrayTask getLongestDurationTask() {
        if (tasks.isEmpty()) return null;
        ArrayTask maxTask = tasks.get(0);
        for (ArrayTask t : tasks) {
            if (t.getDuration() > maxTask.getDuration()) maxTask = t;
        }
        return maxTask;
    }

    public static ArrayList<ArrayTask> getTasksByDeveloper(String developer) {
        ArrayList<ArrayTask> result = new ArrayList<>();
        for (ArrayTask t : tasks) {
            if (t.getDeveloper().equalsIgnoreCase(developer)) result.add(t);
        }
        return result;
    }

    public static ArrayTask getTaskByName(String taskName) {
        for (ArrayTask t : tasks) {
            if (t.getTaskName().equalsIgnoreCase(taskName)) return t;
        }
        return null;
    }

    public static boolean deleteTaskByName(String taskName) {
        Iterator<ArrayTask> iter = tasks.iterator();
        int idx = -1;
        int i = 0;
        while (iter.hasNext()) {
            ArrayTask t = iter.next();
            if (t.getTaskName().equalsIgnoreCase(taskName)) {
                idx = i;
                iter.remove();
                break;
            }
            i++;
        }
        if (idx != -1) {
            developers.remove(idx);
            taskNames.remove(idx);
            taskIDs.remove(idx);
            taskDurations.remove(idx);
            taskStatuses.remove(idx);
            return true;
        }
        return false;
    }

    public static String getFullReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("*** ALL TASKS REPORT ***\n");
        for (ArrayTask t : tasks) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }
 // For unit test simulation(Netbeans add this as a correction)
    public static ArrayList<String> getDevelopersArray() {
        return new ArrayList<>(developers);
   
    }
}