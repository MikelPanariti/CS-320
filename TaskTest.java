package test;

import main.java.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("1234567890", "Valid Task", "Valid Description");

        assertEquals("1234567890", task.getTaskId());
        assertEquals("Valid Task", task.getTaskName());
        assertEquals("Valid Description", task.getTaskDescription());
    }

    @Test
    @DisplayName("Invalid Task ID: Null")
    public void testInvalidTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
    }

    @Test
    @DisplayName("Invalid Task ID: Exceeds Maximum Length")
    public void testInvalidTaskIdExceedsMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
    }



    @Test
    @DisplayName("Invalid Task Name: Null")
    public void testInvalidTaskNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", null, "Task Description"));
    }

    @Test
    @DisplayName("Invalid Task Name: Exceeds Maximum Length")
    public void testInvalidTaskNameExceedsMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Task Name That Is Too Long", "Task Description"));
    }



    @Test
    @DisplayName("Invalid Task Description: Null")
    public void testInvalidTaskDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Task Name", null));
    }

   



    @Test
    @DisplayName("Update Task Name")
    public void testUpdateTaskName() {
        Task task = new Task("1234567890", "Original Name", "Task Description");

        task.setTaskName("New Name");

        assertEquals("New Name", task.getTaskName());
    }

    @Test
    @DisplayName("Update Task Name with Null")
    public void testUpdateTaskNameWithNull() {
        Task task = new Task("1234567890", "Original Name", "Task Description");

        assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
    }

    @Test
    @DisplayName("Update Task Name with Long Name")
    public void testUpdateTaskNameWithLongName() {
        Task task = new Task("1234567890", "Original Name", "Task Description");

        assertThrows(IllegalArgumentException.class, () -> task.setTaskName("New Name That Is Too Long"));
    }

    @Test
    @DisplayName("Update Task Description")
    public void testUpdateTaskDescription() {
        Task task = new Task("1234567890", "Task Name", "Original Description");

        task.setTaskDescription("New Description");

        assertEquals("New Description", task.getTaskDescription());
    }

    @Test
    @DisplayName("Update Task Description with Null")
    public void testUpdateTaskDescriptionWithNull() {
        Task task = new Task("1234567890", "Task Name", "Original Description");

        assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(null));
    }

    
}

