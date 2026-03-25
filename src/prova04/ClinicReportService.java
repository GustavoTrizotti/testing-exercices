package prova04;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ClinicReportService {
    private final AppointmentRepository appointmentRepository;

    public ClinicReportService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = Objects.requireNonNull(appointmentRepository);
    }

    public double averageDelayMinutes(UUID doctorId, LocalDate date) {
        Objects.requireNonNull(doctorId, "doctorId is required");
        Objects.requireNonNull(date, "date is required");

        List<Appointment> appointments = appointmentRepository.findByDoctorIdAndDate(doctorId, date);
        if (appointments == null || appointments.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Appointment appointment : appointments) {
            total += appointment.getDelayMinutes();
        }

        return total / appointments.size();
    }
}
