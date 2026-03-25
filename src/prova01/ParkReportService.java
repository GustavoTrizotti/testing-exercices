package prova01;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ParkReportService {
    private final TicketPurchaseRepository ticketPurchaseRepository;

    public ParkReportService(TicketPurchaseRepository ticketPurchaseRepository) {
        this.ticketPurchaseRepository = Objects.requireNonNull(ticketPurchaseRepository);
    }

    public double averageSpentByVisitor(UUID visitorId) {
        Objects.requireNonNull(visitorId, "visitorId is required");

        List<TicketPurchase> purchases = ticketPurchaseRepository.findByVisitorId(visitorId);
        if (purchases == null || purchases.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (TicketPurchase purchase : purchases) {
            total += purchase.getAmountPaid();
        }

        return total / purchases.size();
    }
}
