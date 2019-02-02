package Lesson4HW;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {0, 0};
        System.out.println("\n" + Arrays.toString(array1) + " :: First array");
        System.out.println(Arrays.toString(array2) + " :: Second array");
        System.out.println(Arrays.toString(mergeArrays(array1, array2)) + " :: Array merged from two source arrays");
    }

    private static int[] mergeArrays(int[] source1, int[] source2) {
        int[] mergedArray = new int[source1.length + source2.length];
        int iSource1 = 0;
        int iSource2 = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            while (iSource1 < source1.length && iSource2 < source2.length) {
                mergedArray[i] = source1[iSource1];
                mergedArray[i + 1] = source2[iSource2];
                i += 2;
                iSource1++;
                iSource2++;
            }
            if (iSource1 < source1.length) {
                mergedArray[i] = source1[iSource1];
                iSource1++;
            } else if (iSource2 < source2.length) {
                mergedArray[i] = source2[iSource2];
                iSource2++;
            }
        }
        return mergedArray;
    }
}
