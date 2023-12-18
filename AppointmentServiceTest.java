package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Appointment;
import main.java.AppointmentService;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date currentDate = new Date();
        Appointment appointment = new Appointment("1234567890", currentDate, "Test Appointment");

        appointmentService.addAppointment(appointment);

        List<Appointment> appointments = appointmentService.getAppointments();
        assertEquals(1, appointments.size());
        assertEquals(appointment, appointments.get(0));
    }

    @Test
    public void testDeleteAppointment() {
        Date currentDate = new Date();
        Appointment appointment = new Appointment("1234567890", currentDate, "Test Appointment");

        appointmentService.addAppointment(appointment);
        assertEquals(1, appointmentService.getAppointments().size());

        appointmentService.deleteAppointment("1234567890");

        assertEquals(0, appointmentService.getAppointments().size());
    }

    @Test
    public void testAddDuplicateAppointment() {
        Date currentDate = new Date();
        Appointment appointment1 = new Appointment("1234567890", currentDate, "Test Appointment 1");
        Appointment appointment2 = new Appointment("1234567890", currentDate, "Test Appointment 2");

        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment2));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("nonexistentID");
        });
    }

    @Test
    public void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(null));
    }

    
}
