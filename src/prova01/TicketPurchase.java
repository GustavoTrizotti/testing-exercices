package prova01;

import java.util.UUID;

public class TicketPurchase {
    private final UUID visitorId;
    private final double amountPaid;

    public TicketPurchase(UUID visitorId, double amountPaid) {
        this.visitorId = visitorId;
        this.amountPaid = amountPaid;
    }

    public UUID getVisitorId() {
        return visitorId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
