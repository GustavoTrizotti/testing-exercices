package prova05;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BillingReportService {
    private final InvoiceRepository invoiceRepository;

    public BillingReportService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = Objects.requireNonNull(invoiceRepository);
    }

    public BigDecimal averagePaidInvoiceAmount(UUID accountId, Instant from, Instant to) {
        Objects.requireNonNull(accountId, "accountId is required");
        Objects.requireNonNull(from, "from is required");
        Objects.requireNonNull(to, "to is required");

        if (from.isAfter(to)) {
            throw new IllegalArgumentException("from cannot be after to");
        }

        List<Invoice> invoices = invoiceRepository.findPaidInvoices(accountId, from, to);
        if (invoices == null || invoices.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = BigDecimal.ZERO;
        for (Invoice invoice : invoices) {
            total = total.add(invoice.getPaidAmount());
        }

        return total.divide(BigDecimal.valueOf(invoices.size()), 2, RoundingMode.HALF_UP);
    }
}
