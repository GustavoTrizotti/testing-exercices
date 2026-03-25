package prova02;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class DeliveryAnalyticsService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryAnalyticsService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = Objects.requireNonNull(deliveryRepository);
    }

    public double averageDeliveryTimeInHours(String city, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(city, "city is required");
        Objects.requireNonNull(startDate, "startDate is required");
        Objects.requireNonNull(endDate, "endDate is required");

        if (city.isBlank()) {
            throw new IllegalArgumentException("city cannot be blank");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("startDate cannot be after endDate");
        }

        List<Delivery> deliveries = deliveryRepository.findByCityAndPeriod(city, startDate, endDate);
        if (deliveries == null || deliveries.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Delivery delivery : deliveries) {
            total += delivery.getDurationInHours();
        }

        return total / deliveries.size();
    }
}
