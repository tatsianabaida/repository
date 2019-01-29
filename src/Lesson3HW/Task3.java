package Lesson3HW;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Please enter amount of days: ");
        int numberOfDays = enterValue();
        int precipitationSum = 0;
        int precipitationMax = 0;
        if (numberOfDays != 0) {
            for (int i = 0; i < numberOfDays; i++) {
                System.out.println("Please enter precipitation amount for " + " day " + (i + 1) + ":");
                int precipitation = enterValue();
                precipitationSum += precipitation;
                precipitationMax = getMax(precipitationMax, precipitation);
            }
            int precipitationAverage = getAverage(numberOfDays, precipitationSum);
            System.out.println("\nAmount of days: " + numberOfDays + ";" +
                    "\nPrecipitation in total during " + numberOfDays + " days: " + precipitationSum + ";" +
                    "\nAverage precipitation per day: " + precipitationAverage + ";" +
                    "\nMaximum precipitation during " + numberOfDays + " days: " + precipitationMax + ".");
        } else {
            System.out.println("\nAmount of days: " + numberOfDays + ";" +
                    "\nPrecipitation in total: " + numberOfDays + ";" +
                    "\nAverage precipitation: " + numberOfDays + ";" +
                    "\nMaximum precipitation: " + numberOfDays + ".");
        }
    }

    private static int getAverage(int numberOfDays, int precipitationSum) {
        return precipitationSum / numberOfDays;
    }

    private static int getMax(int precipitationMax, int precipitation) {
        if (precipitationMax < precipitation) {
            precipitationMax = precipitation;
        }
        return precipitationMax;
    }

    private static int enterValue() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x < 0) {
            System.out.println("Cannot be negative. Please enter again: ");
            x = enterValue();
        }
        return x;
    }
}
