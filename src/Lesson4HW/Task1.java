package Lesson4HW;

import java.util.Arrays;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(array) + " :: Source array");
        System.out.println(Arrays.toString(shiftArray(array)) + " :: Shifted array");
        System.out.println(Arrays.toString(shiftArray(shiftArray(shiftArray(array)))) + " :: Shifted by 3 elements");
    }

    private static int[] shiftArray(int[] source) {
        int[] target = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            if (i == source.length - 1) {
                target[0] = source[i];
            } else {
                target[i + 1] = source[i];
            }
        }
        return target;
    }
}
