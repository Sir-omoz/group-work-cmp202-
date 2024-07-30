import java.util.Scanner;
import java.util.InputMismatchException;

public class CurrencyConverter {

    // Define conversion rates
    private static final double USD_TO_EUR_RATE = 0.85;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the amount in USD: ");
            double amountInUSD = scanner.nextDouble();

            if (amountInUSD < 0) {
                throw new IllegalArgumentException("Amount cannot be negative.");
            }

            double amountInEUR = convertUSDtoEUR(amountInUSD);
            System.out.printf("Amount in EUR: %.2f\n", amountInEUR);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double convertUSDtoEUR(double amountInUSD) {
        return amountInUSD * USD_TO_EUR_RATE;
    }
}
