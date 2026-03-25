package prova02;

public class FreightCalculator {

    public double calculateFreight(double weightKg, double distanceKm, String serviceLevel) {
        validateWeight(weightKg);
        validateDistance(distanceKm);
        validateServiceLevel(serviceLevel);

        double total = calculateBasePrice(weightKg);

        if (distanceKm > 300.0) {
            total += 8.0;
        }

        if ("EXPRESS".equals(serviceLevel)) {
            total *= 1.25;
        }

        return total;
    }

    private void validateWeight(double weightKg) {
        if (weightKg <= 0.0 || weightKg > 50.0) {
            throw new IllegalArgumentException("weightKg must be > 0 and <= 50.0");
        }
    }

    private void validateDistance(double distanceKm) {
        if (distanceKm < 1.0 || distanceKm > 1000.0) {
            throw new IllegalArgumentException("distanceKm must be between 1.0 and 1000.0");
        }
    }

    private void validateServiceLevel(String serviceLevel) {
        if (!"STANDARD".equals(serviceLevel) && !"EXPRESS".equals(serviceLevel)) {
            throw new IllegalArgumentException("serviceLevel must be STANDARD or EXPRESS");
        }
    }

    private double calculateBasePrice(double weightKg) {
        if (weightKg <= 1.0) {
            return 15.0;
        }
        if (weightKg <= 10.0) {
            return 15.0 + ((weightKg - 1.0) * 2.0);
        }
        return 33.0 + ((weightKg - 10.0) * 3.0);
    }
}
