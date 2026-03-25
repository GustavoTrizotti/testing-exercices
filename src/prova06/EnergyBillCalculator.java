package prova06;

public class EnergyBillCalculator {
    public double calculateBill(double kwh) {
        if (kwh < 0) {
            throw new IllegalArgumentException("O consumo de energia não pode ser negativo.");
        }

        double totalAmount = 0.0;

        if (kwh <= 100) {
            totalAmount = kwh * 0.50;
        } else if (kwh <= 300) {
            totalAmount = (100 * 0.50) + ((kwh - 100) * 0.80);
        } else {
            totalAmount = (100 * 0.50) + (200 * 0.80) + ((kwh - 300) * 1.20) + 20.00;
        }

        return totalAmount;
    }
}
