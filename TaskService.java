package main.java;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        // Check if task ID is unique before adding
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with ID " + task.getTaskId() + " already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        // Check if task ID exists before deleting
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        // Check if task ID exists before updating
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
        // Update the task's name
        Task task = tasks.get(taskId);
        task.setTaskName(newName);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        // Check if task ID exists before updating
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
        }
        // Update the task's description
        Task task = tasks.get(taskId);
        task.setTaskDescription(newDescription);
    }

    

    // Added method to retrieve tasks (for testing purposes)
    public Map<String, Task> getTasks() {
        return new HashMap<>(tasks);
    }
}
