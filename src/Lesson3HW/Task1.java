package Lesson3HW;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter integer value: ");
        int value = scanner.nextInt();
        System.out.println("Sum of digits for entered value: " + Math.abs(sumOfDigits(value)));
    }

    private static int sumOfDigits(int value) {
        int result = 0;
        for (; value != 0; ) {
            result += (value % 10);
            value = value / 10;
        }
        return result;
    }
}
