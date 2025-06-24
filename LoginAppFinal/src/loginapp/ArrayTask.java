package loginapp;

public class ArrayTask {
    private String developer;
    private String taskName;
    private String taskID;
    private int duration;
    private String status;

    public ArrayTask(String developer, String taskName, String taskID, int duration, String status) {
        this.developer = developer;
        this.taskName = taskName;
        this.taskID = taskID;
        this.duration = duration;
        this.status = status;
    }

    public String getDeveloper() { return developer; }
    public String getTaskName() { return taskName; }
    public String getTaskID() { return taskID; }
    public int getDuration() { return duration; }
    public String getStatus() { return status; }

    public void setDeveloper(String developer) { this.developer = developer; }
    public void setTaskName(String taskName) { this.taskName = taskName; }
    public void setTaskID(String taskID) { this.taskID = taskID; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format(
            "Developer: %s\nTask Name: %s\nTask ID: %s\nTask Duration: %d\nTask Status: %s\n",
            developer, taskName, taskID, duration, status
        );
    }
}