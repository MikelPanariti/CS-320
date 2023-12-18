package main.java;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        validateAppointmentNotNull(appointment);

        // Check for duplicate appointment IDs
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getAppointmentID().equals(appointment.getAppointmentID())) {
                throw new IllegalArgumentException("An appointment with the same ID already exists.");
            }
        }

        appointments.add(appointment);
    }

  
    public void deleteAppointment(String appointmentID) {
        Appointment appointmentToRemove = null;

        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointmentToRemove = appointment;
                break;
            }
        }

        if (appointmentToRemove == null) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentID + " does not exist.");
        }

        appointments.remove(appointmentToRemove);
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    private void validateAppointmentNotNull(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }
    }
}
