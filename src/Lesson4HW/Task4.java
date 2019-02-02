package Lesson4HW;

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {0, 0}, {}, {4, 4, 4, 4}};
        System.out.println("Source array:");
        sout2DArray(array);
        System.out.println("\nLinearized array:\n" + Arrays.toString(linearize(array)));
    }

    private static int[] linearize(int[][] source) {
        int iLinearizedArray = 0;
        int[] linearizedArray = initializeLinearizedArray(source);

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++, iLinearizedArray++) {
                linearizedArray[iLinearizedArray] = source[i][j];
            }
        }
        return linearizedArray;
    }

    private static int[] initializeLinearizedArray(int[][] source) {
        int linearizedArrayLength = 0;
        for (int i = 0; i < source.length; i++) {
            linearizedArrayLength += source[i].length;
        }
        return new int[linearizedArrayLength];
    }

    private static void sout2DArray(int[][] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                System.out.print((source[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
