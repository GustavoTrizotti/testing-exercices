package prova04;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository {
    List<Appointment> findByDoctorIdAndDate(UUID doctorId, LocalDate date);
}
