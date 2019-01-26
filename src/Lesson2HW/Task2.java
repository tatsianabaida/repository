package Lesson2HW;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Please enter side A value for the first house: ");
        int a = enterSide();
        System.out.println("Please enter side B value for the first house: ");
        int b = enterSide();
        System.out.println("Please enter side C value for the second house: ");
        int c = enterSide();
        System.out.println("Please enter side D value for the second house: ");
        int d = enterSide();
        System.out.println("Please enter side E value for target area: ");
        int e = enterSide();
        System.out.println("Please enter side F value for target area: ");
        int f = enterSide();
        if (isFit(a, b, c, d, e, f)) {
            System.out.println("ExF area can contain houses AxB and CxD.");
        } else System.out.println("There is no possibility to locate both houses AxB and CxD on the ExF area.");
    }

    private static int enterSide() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x <= 0) {
            System.out.println("Wrong side value. Please enter it correctly: ");
            x = enterSide();
        }
        return x;
    }

    private static int largerSide(int firstSide, int secondSide) {
        int largerSide = firstSide;
        if (secondSide > firstSide) {
            largerSide = secondSide;
        }
        return largerSide;
    }

    private static int rectangleArea(int firstSide, int secondSide) {
        return (firstSide * secondSide);
    }

    private static boolean isFit(int a, int b, int c, int d, int e, int f) {
        boolean isPossible = false;
        if (isEnoughPlace(rectangleArea(a, b), rectangleArea(c, d), rectangleArea(e, f))) {
            if ((isEnoughPlace(b, c, e) && largerSide(a, d) <= f) ||
                (isEnoughPlace(b, c, f) && largerSide(a, d) <= e) ||
                (isEnoughPlace(a, c, e) && largerSide(b, d) <= f) || //ничего лаконичнее придумать не удалось :)
                (isEnoughPlace(a, c, f) && largerSide(a, d) <= e)) {
                isPossible = true;
            }
        }
        return isPossible;
    }

    private static boolean isEnoughPlace(int x, int y, int z) {
        return x + y <= z;
    }
}
