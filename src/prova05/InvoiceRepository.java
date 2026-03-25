package prova05;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface InvoiceRepository {
    List<Invoice> findPaidInvoices(UUID accountId, Instant from, Instant to);
}
