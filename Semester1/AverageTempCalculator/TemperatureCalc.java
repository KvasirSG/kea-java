package Semester1.AverageTempCalculator;

import java.util.Scanner;

public class TemperatureCalc {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("How many days?: ");
        int days = scn.nextInt();
        scn.nextLine();
        int[] temperatures = askForTemps(days);
        double average = calcAverage(temperatures);
        int aboveAverageDays = daysAboveAverage(average, temperatures);
        for (int i = 0; i < days; i++) {
            int day = i + 1;
            System.out.println("Day " + day + "'s high temp: " + temperatures[i]);
        }
        System.out.printf("Average Temp = %.1f\n", average);
        System.out.println(aboveAverageDays + " days were above average");
    }

    static int[] askForTemps(int days) {
        int[] temp = new int[days];
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < days; i++) {
            int day = i + 1;
            System.out.print("Enter Temperature for day " + day + ": ");
            temp[i] = scn.nextInt();
            scn.nextLine();
        }
        return temp;
    }

    static double calcAverage(int[] temperatures) {
        int temp = 0;
        for (int i = 0; i < temperatures.length; i++) {
            temp += temperatures[i];
        }
        return (double) temp / temperatures.length;
    }

    static int daysAboveAverage(double average, int[] temperatures) {
        int temp = 0;
        for (int temperature : temperatures) {
            if (temperature > average) {
                temp++;
            }
        }
        return temp;
    }
}
