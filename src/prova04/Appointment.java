package prova04;

import java.time.LocalDate;
import java.util.UUID;

public class Appointment {
    private final UUID doctorId;
    private final LocalDate date;
    private final double delayMinutes;

    public Appointment(UUID doctorId, LocalDate date, double delayMinutes) {
        this.doctorId = doctorId;
        this.date = date;
        this.delayMinutes = delayMinutes;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getDelayMinutes() {
        return delayMinutes;
    }
}
