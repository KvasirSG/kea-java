package Semester1.CurrencyConverter;

import java.util.Scanner;

public class Cash {
    static double dkk_euro = 7.44;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runConverter();
    }

    static void runConverter() {
        while (true) {
            System.out.println("Vælg 1 for DKK>Euro.2 for Euro>DKK");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Indtast DKK: ");
                double input = scanner.nextDouble();
                double result = convertToEuro(input);
                System.out.println(result + " euroes");
            }
            if (choice == 2) {
                System.out.print("Indtast Euro: ");
                double input = scanner.nextDouble();
                double result = convertToDKK(input);
                System.out.println(result + " DKK");
            }
            if (choice == 0) {
                break;
            }
        }
    }

    static double convertToDKK(double euro) {
        return euro * dkk_euro;
    }

    static double convertToEuro(double dkk) {
        return dkk / dkk_euro;
    }
}