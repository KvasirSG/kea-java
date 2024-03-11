package Semester1.CurrencyConverter;

import java.util.Scanner;

public class CurrencyConverter {
    static double dkk_euro = 7.44;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        converter();
    }

    static void converter() {
        boolean exit = false;
        while (exit == false) {
            System.out.println("1. For DKK to EUR\n2. For EUR to DKK\n0. For Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Type amount in DKK: ");
                    double amountDkk = scanner.nextDouble();
                    System.out.println(amountDkk + " in DKK is " + dkkToEur(amountDkk) + " Eur.");
                    break;
                case 2:
                    System.out.print("Type amount in Eur: ");
                    double amountEur = scanner.nextDouble();
                    System.out.println(amountEur + " in Eur is " + dkkToEur(amountEur) + " DKK.");
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    break;
            }

        }
    }

    static double dkkToEur(double dkk) {
        return dkk * dkk_euro;
    }

    static double eurToDkk(double eur) {
        return eur / dkk_euro;
    }

}
