package prova03;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class LibraryReportService {
    private final LoanRepository loanRepository;

    public LibraryReportService(LoanRepository loanRepository) {
        this.loanRepository = Objects.requireNonNull(loanRepository);
    }

    public double averageLoanDays(String isbn, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(isbn, "isbn is required");
        Objects.requireNonNull(startDate, "startDate is required");
        Objects.requireNonNull(endDate, "endDate is required");

        if (isbn.isBlank()) {
            throw new IllegalArgumentException("isbn cannot be blank");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("startDate cannot be after endDate");
        }

        List<Loan> loans = loanRepository.findByIsbnAndPeriod(isbn, startDate, endDate);
        if (loans == null || loans.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Loan loan : loans) {
            total += loan.getDurationInDays();
        }

        return total / loans.size();
    }
}
