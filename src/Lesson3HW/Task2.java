package Lesson3HW;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("Please enter integer value: ");
        int value = enterValue();
        int n_2 = 0;
        int n_1 = 1;

        if (value == 0) {
            System.out.println("F(n): " + n_2);
        } else {
            System.out.println("\nFibonacci via cycle:");
            cycleFibonacciSout(value, n_2, n_1);
            System.out.println("\nFibonacci via recursion:");
            recursionFibonacciSout(n_2, n_1, value);
        }
    }

    private static void cycleFibonacciSout(int value, int n_2, int n_1) {
        for (int n; n_2 + n_1 <= value; n_2 = n_1, n_1 = n) {
            n = n_2 + n_1;
            System.out.println("F(n): " + n + "  F(n-1): " + n_1 + "  F(n-2): " + n_2); //не получилось обойтись без sout, помню, что лучше так не делать)
        }
    }

    private static void recursionFibonacciSout(int n_2, int n_1, int value) {
        if (n_2 + n_1 <= value) {
            int n = n_2 + n_1;
            System.out.println("F(n): " + n + "  F(n-1): " + n_1 + "  F(n-2): " + n_2);
            recursionFibonacciSout(n_1, n, value); //согласна, так себе решение через рекурсию
            // там в чат отличное видео скидывали, но я бы сама не додумалась до такого)
        }
    }

    private static int enterValue() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        while (x < 0) {
            System.out.println("Cannot be negative. Please enter again: ");
            x = scanner.nextInt();
        }
        return x;
    }
}
