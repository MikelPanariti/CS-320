package test;

import org.junit.jupiter.api.Test;
import main.java.Task;
import main.java.TaskService;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");

        taskService.addTask(task);

        Map<String, Task> tasks = taskService.getTasks();
        assertTrue(tasks.containsKey("1"));
        assertEquals(task, tasks.get("1"));
    }

    @Test
    public void testAddDuplicateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");

        taskService.addTask(task);

        // Adding the same task again should throw an exception
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task));
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);

        taskService.deleteTask("1");

        Map<String, Task> tasks = taskService.getTasks();
        assertFalse(tasks.containsKey("1"));
    }

    @Test
    public void testDeleteNonExistentTask() {
        TaskService taskService = new TaskService();

        // Deleting a non-existent task should throw an exception
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("nonexistentID"));
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);

        taskService.updateTaskName("1", "New Task Name");

        Map<String, Task> tasks = taskService.getTasks();
        assertEquals("New Task Name", tasks.get("1").getTaskName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);

        taskService.updateTaskDescription("1", "New Task Description");

        Map<String, Task> tasks = taskService.getTasks();
        assertEquals("New Task Description", tasks.get("1").getTaskDescription());
    }

    @Test
    public void testUpdateNonExistentTaskName() {
        TaskService taskService = new TaskService();

        // Updating the name of a non-existent task should throw an exception
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("nonexistentID", "New Task Name"));
    }

    @Test
    public void testUpdateNonExistentTaskDescription() {
        TaskService taskService = new TaskService();

        // Updating the description of a non-existent task should throw an exception
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("nonexistentID", "New Task Description"));
    }

  
}
