package prova02;

import java.time.LocalDate;

public class Delivery {
    private final String city;
    private final LocalDate deliveredAt;
    private final double durationInHours;

    public Delivery(String city, LocalDate deliveredAt, double durationInHours) {
        this.city = city;
        this.deliveredAt = deliveredAt;
        this.durationInHours = durationInHours;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDeliveredAt() {
        return deliveredAt;
    }

    public double getDurationInHours() {
        return durationInHours;
    }
}
