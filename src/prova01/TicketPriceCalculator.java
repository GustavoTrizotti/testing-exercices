package prova01;

public class TicketPriceCalculator {

    public int calculateTicketPrice(int age, int premiumAttractions) {
        validateAge(age);
        validatePremiumAttractions(premiumAttractions);

        int basePrice = calculateBasePrice(age);
        int premiumAdditional = calculatePremiumAdditional(premiumAttractions);
        return basePrice + premiumAdditional;
    }

    private void validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("age must be between 0 and 120");
        }
    }

    private void validatePremiumAttractions(int premiumAttractions) {
        if (premiumAttractions < 1 || premiumAttractions > 10) {
            throw new IllegalArgumentException("premiumAttractions must be between 1 and 10");
        }
    }

    private int calculateBasePrice(int age) {
        if (age <= 5) {
            return 0;
        }
        if (age <= 12) {
            return 20;
        }
        if (age <= 59) {
            return 35;
        }
        return 18;
    }

    private int calculatePremiumAdditional(int premiumAttractions) {
        if (premiumAttractions <= 3) {
            return 0;
        }
        if (premiumAttractions <= 7) {
            return 10;
        }
        return 18;
    }
}
