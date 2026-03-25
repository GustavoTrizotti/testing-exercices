package prova05;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class LatePaymentCalculator {

    public BigDecimal calculateLatePaymentAmount(BigDecimal originalAmount, LocalDate dueDate, Instant paymentTimestamp) {
        Objects.requireNonNull(originalAmount, "originalAmount is required");
        Objects.requireNonNull(dueDate, "dueDate is required");
        Objects.requireNonNull(paymentTimestamp, "paymentTimestamp is required");

        if (originalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("originalAmount must be greater than zero");
        }

        LocalDate paymentDate = paymentTimestamp.atZone(ZoneOffset.UTC).toLocalDate();
        if (!paymentDate.isAfter(dueDate)) {
            return originalAmount.setScale(2, RoundingMode.HALF_UP);
        }

        long lateDays = ChronoUnit.DAYS.between(dueDate, paymentDate);
        long chargedDays = Math.min(lateDays, 30);

        BigDecimal fine = percentage(originalAmount, "0.02");
        BigDecimal interests = percentage(originalAmount, "0.001").multiply(BigDecimal.valueOf(chargedDays));

        return originalAmount
                .add(fine)
                .add(interests)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal percentage(BigDecimal value, String rate) {
        return value.multiply(new BigDecimal(rate));
    }
}
