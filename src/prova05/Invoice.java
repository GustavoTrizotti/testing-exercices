package prova05;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Invoice {
    private final UUID accountId;
    private final BigDecimal paidAmount;
    private final Instant paidAt;

    public Invoice(UUID accountId, BigDecimal paidAmount, Instant paidAt) {
        this.accountId = accountId;
        this.paidAmount = paidAmount;
        this.paidAt = paidAt;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public Instant getPaidAt() {
        return paidAt;
    }
}
