package prova03;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository {
    List<Loan> findByIsbnAndPeriod(String isbn, LocalDate startDate, LocalDate endDate);
}
