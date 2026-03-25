package prova01;

import java.util.List;
import java.util.UUID;

public interface TicketPurchaseRepository {
    List<TicketPurchase> findByVisitorId(UUID visitorId);
}
