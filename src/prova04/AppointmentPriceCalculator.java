package prova04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AppointmentPriceCalculator {

    public double calculateAppointmentPrice(LocalDate appointmentDate, LocalTime appointmentTime, String specialty, boolean firstVisit) {
        Objects.requireNonNull(appointmentDate, "appointmentDate is required");
        Objects.requireNonNull(appointmentTime, "appointmentTime is required");
        Objects.requireNonNull(specialty, "specialty is required");

        validateBusinessDay(appointmentDate);
        validateTime(appointmentTime);

        double basePrice = resolveBasePrice(specialty);
        if (hasTimeSurcharge(appointmentTime)) {
            basePrice *= 1.15;
        }

        if (firstVisit) {
            basePrice += 20.0;
        }

        return basePrice;
    }

    private void validateBusinessDay(LocalDate appointmentDate) {
        DayOfWeek dayOfWeek = appointmentDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("appointmentDate must be a business day");
        }
    }

    private void validateTime(LocalTime appointmentTime) {
        LocalTime openingTime = LocalTime.of(8, 0);
        LocalTime closingTime = LocalTime.of(19, 0);

        if (appointmentTime.isBefore(openingTime) || appointmentTime.isAfter(closingTime)) {
            throw new IllegalArgumentException("appointmentTime must be between 08:00 and 19:00");
        }
    }

    private double resolveBasePrice(String specialty) {
        return switch (specialty) {
            case "GENERAL" -> 120.0;
            case "DERMATOLOGY" -> 180.0;
            case "ORTHOPEDICS" -> 200.0;
            default -> throw new IllegalArgumentException("invalid specialty");
        };
    }

    private boolean hasTimeSurcharge(LocalTime appointmentTime) {
        return appointmentTime.isBefore(LocalTime.of(9, 0)) || !appointmentTime.isBefore(LocalTime.of(18, 0));
    }
}
