package test.java;
import org.junit.jupiter.api.Test;

import main.java.Appointment;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Date currentDate = new Date();
        Appointment appointment = new Appointment("1234567890", currentDate, "Test Appointment");

        assertEquals("1234567890", appointment.getAppointmentID());
        assertEquals(currentDate, appointment.getAppointmentDate());
        assertEquals("Test Appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Test Appointment"));
    }

    @Test
    public void testInvalidAppointmentIDLength() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(), "Test Appointment"));
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", pastDate, "Test Appointment"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", new Date(), null));
    }

    @Test
    public void testInvalidDescriptionLength() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", new Date(), "This is a very long description that exceeds 50 characters limit."));
    }

 
}
