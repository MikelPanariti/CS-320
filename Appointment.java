package main.java;

import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private final Date appointmentDate;
    private final String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        validateAppointmentID(appointmentID);
        validateAppointmentDate(appointmentDate);
        validateDescription(description);

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    private void validateAppointmentID(String appointmentID) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must not be null and should not exceed 10 characters.");
        }
    }

    private void validateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date must not be null and should not be in the past.");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and should not exceed 50 characters.");
        }
    }
}
