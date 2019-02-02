package Lesson4HW;

import java.util.Arrays;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {
        int[] array = new int[11];
        fillArrayWithRandomValues(array);
        System.out.println("\n" + Arrays.toString(array) + " :: Source array");
        System.out.println(Arrays.toString(removeEqualElements(array)) + " :: Array with equal elements removed");
    }

    private static int[] removeEqualElements(int[] source) {
        int[] target = Arrays.copyOf(source, source.length);
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i] == source[j]) {
                    target[i] = 0;
                    target[j] = 0;
                }
            }
        }
        return target;
    }

    private static void fillArrayWithRandomValues(int[] source) {
        Random random = new Random();
        for (int i = 0; i < source.length; i++) {
            source[i] = random.nextInt(9) + 1;
        }
    }
}
