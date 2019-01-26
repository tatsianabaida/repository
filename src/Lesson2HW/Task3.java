package Lesson2HW;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter value for coefficient 'a' for quadratic equation ax^2 + bx^1 + cx^0 = 0 : ");
        double a = enterCoefficientA();
        System.out.println("Please enter value for coefficient 'b': ");
        double b = scanner.nextDouble();
        System.out.println("Please enter value for coefficient 'c': ");
        double c = scanner.nextDouble();
        calculateRoots(a, b, c);
    }

    private static void calculateRoots(double a, double b, double c) {
        if (isPositive(discriminant(a, b, c))) {
            double x1 = (-b - Math.sqrt(discriminant(a, b, c))) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant(a, b, c))) / (2 * a);
            System.out.println("Discriminant equals " + discriminant(a, b, c) + ". \nThere are two roots in the equation: x1 = " + x1 + "; x2 = " + x2 + ".");
        } else if (isZero(discriminant(a, b, c))) {
            double x = (-1) * b / (2 * a);
            System.out.println("Discriminant is " + discriminant(a, b, c) + ". \nThere is only one root in the equation: x = " + x + ".");
        } else {
            System.out.println("Discriminant is negative, it means there are 2 complex roots but they won't be calculated by me. :)");
        }
    }

    private static double enterCoefficientA() {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        if (isZero(a)) {
            System.out.println("Coefficient 'a' cannot be 0. Please enter other value: ");
            a = enterCoefficientA();
        }
        return a;
    }

    private static boolean isPositive(double x) {
        return (x > 0);
    }

    private static boolean isZero(double x) {
        return (x == 0);
    }

    private static double discriminant(double a, double b, double c) {
        return (b * b - 4 * a * c);
    }
}

