package prova02;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository {
    List<Delivery> findByCityAndPeriod(String city, LocalDate startDate, LocalDate endDate);
}
