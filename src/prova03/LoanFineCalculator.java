package prova03;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class LoanFineCalculator {

    public double calculateFine(LocalDate dueDate, LocalDate returnDate, String memberType) {
        Objects.requireNonNull(dueDate, "dueDate is required");
        Objects.requireNonNull(returnDate, "returnDate is required");
        Objects.requireNonNull(memberType, "memberType is required");

        double dailyRate = resolveDailyRate(memberType);

        if (!returnDate.isAfter(dueDate)) {
            return 0.0;
        }

        long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        double fine = lateDays * dailyRate;
        return Math.min(fine, 90.0);
    }

    private double resolveDailyRate(String memberType) {
        return switch (memberType) {
            case "STUDENT" -> 1.50;
            case "TEACHER" -> 0.75;
            case "VISITOR" -> 3.00;
            default -> throw new IllegalArgumentException("invalid memberType");
        };
    }
}
