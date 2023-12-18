package main.java;

public class Task {
    private final String taskId;
    private String taskName;
    private String taskDescription;

    public Task(String taskId, String taskName, String taskDescription) {
        validateTaskId(taskId);
        validateTaskName(taskName);
        validateTaskDescription(taskDescription);

        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    // Setters with validation
    public void setTaskName(String taskName) {
        validateTaskName(taskName);
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        validateTaskDescription(taskDescription);
        this.taskDescription = taskDescription;
    }

    // Private helper methods for validation
    private void validateTaskId(String taskId) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and cannot exceed 10 characters.");
        }
    }

    private void validateTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Task name must not be null and cannot exceed 20 characters.");
        }
    }

    private void validateTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Task description must not be null and cannot exceed 50 characters.");
        }
    }
}
