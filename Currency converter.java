import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    // Exchange rates
    static double usdToEur = 0.85;
    static double usdToGbp = 0.75;
    static double eurToUsd = 1.18;
    static double eurToGbp = 0.88;
    static double gbpToUsd = 1.33;
    static double gbpToEur = 1.14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("Available currencies: USD, EUR, GBP");

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (USD, EUR, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

        if (convertedAmount != -1) {
            String result = String.format("%.2f %s is equal to %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
            System.out.println(result);
            writeToFile(result);
        } else {
            System.out.println("Invalid currency conversion request.");
        }

        scanner.close();
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount; // No conversion needed if the currencies are the same
        }

        switch (fromCurrency) {
            case "USD":
                switch (toCurrency) {
                    case "EUR":
                        return amount * usdToEur;
                    case "GBP":
                        return amount * usdToGbp;
                }
                break;
            case "EUR":
                switch (toCurrency) {
                    case "USD":
                        return amount * eurToUsd;
                    case "GBP":
                        return amount * eurToGbp;
                }
                break;
            case "GBP":
                switch (toCurrency) {
                    case "USD":
                        return amount * gbpToUsd;
                    case "EUR":
                        return amount * gbpToEur;
                }
                break;
        }
        return -1; // Return -1 for invalid conversion
    }

    public static void writeToFile(String result) {
        try (FileWriter fileWriter = new FileWriter("conversion_result.txt", true)) {
            fileWriter.write(result + System.lineSeparator());
            System.out.println("Result written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
