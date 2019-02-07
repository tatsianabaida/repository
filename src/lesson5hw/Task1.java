package lesson5hw;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Please enter string value:");
        Scanner scanner = new Scanner(System.in);
        String enteredString = scanner.nextLine();
        System.out.println(isPalindrome(enteredString.trim().toLowerCase())
                ? "Entered string \"" + enteredString.trim() + "\" is palindrome."
                : "Entered string \"" + enteredString.trim() + "\" is not palindrome.");
    }

    private static boolean isPalindrome(String string) {
        boolean result = true;
        int countOfTargetSymbols = string.length() / 2;
        for (int i = 0; i < countOfTargetSymbols; i++) {
            char currentSymbol = string.charAt(i);
            char mirroredSymbol = string.charAt(string.length() - 1 - i);
            if (currentSymbol != mirroredSymbol) {
                result = false;
                break;
            }
        }
        return result;
    }
}
