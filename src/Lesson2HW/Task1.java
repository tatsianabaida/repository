package Lesson2HW;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int year = enterYear();
        int month = enterMonth();
        System.out.println("Amount of days: " + lastDayOfMonth(year, month));
        int day = enterDay(year, month);
        System.out.println("Entered date: " + createDate(day, month, year) + "   Next day: " + nextDayAfterEntered(day, month, year, lastDayOfMonth(year, month)));
    }

    private static int enterYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter year: ");
        int year = scanner.nextInt();
        if (year >= 0) {
            return year;
        } else {
            System.out.println("Such year does not exist.");
            year = enterYear();
        }
        return year;
    }

    private static int enterMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter month: ");
        int month = scanner.nextInt();
        if (month > 0 && month <= 12) {
            return month;
        } else {
            System.out.println("Such month does not exist.");
            month = enterMonth();
        }
        return month;
    }

    private static int enterDay(int year, int month) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter day: ");
        int day = scanner.nextInt();
        if (day > 0 && day <= lastDayOfMonth(year, month)) {
            return day;
        } else {
            System.out.println("Such day does not exist in this month.");
            day = enterDay(year, month);
        }
        return day;
    }

    private static int lastDayOfMonth(int year, int month) {
        int lastDayOfMonth = 0;
        if ((month == 2) && isLeapYear(year)) {
            lastDayOfMonth = 29;
        } else if (month == 2) {
            lastDayOfMonth = 28;
        }
        switch (month) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                lastDayOfMonth = 30 + month % 2;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                lastDayOfMonth = 30 + (month + 1) % 2;
                break;
        }
        return lastDayOfMonth;
    }

    private static boolean isLastDayOfMonth(int lastDayOfMonth, int day) {
        return (day == lastDayOfMonth);
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    private static String nextDayAfterEntered(int day, int month, int year, int lastDayOfMonth) {
        if (month == 12 && isLastDayOfMonth(lastDayOfMonth, day)) {
            //в принципе и для месяца можно было бы создать isLastMonthOfYear на тот случай, если поменяется их количество
            //в требованиях, использовать здесь и в enterMonth, но я решила привязаться к реальной жизни и захардкодать :)
            day = month = 1;
            year++;
        } else if (isLastDayOfMonth(lastDayOfMonth, day)) {
            day = 1;
            month++;
        } else {
            day++;
        }
        return createDate(day, month, year);
    }

    private static String createDate(int day, int month, int year) {
        return (day + "." + month + "." + year);
    }
}

