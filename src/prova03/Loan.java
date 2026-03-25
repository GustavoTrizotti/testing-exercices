package prova03;

import java.time.LocalDate;

public class Loan {
    private final String isbn;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final long durationInDays;

    public Loan(String isbn, LocalDate startDate, LocalDate endDate, long durationInDays) {
        this.isbn = isbn;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInDays = durationInDays;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long getDurationInDays() {
        return durationInDays;
    }
}
