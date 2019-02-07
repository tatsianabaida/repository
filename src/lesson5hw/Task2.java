package lesson5hw;

public class Task2 {

    public static void main(String[] args) {
        String romanValue = "MMCMXCIV";
        System.out.println(romanValue + " :: Roman value");
        System.out.println((convertToArabic(romanValue)) + " :: Arabic value");
    }

    private static int convertToArabic(String romanValue) {
        char[] romanArray = romanValue.toCharArray();
        int[] arabicArray = convertRomanToArabicArray(romanArray);
        return getArabicValue(arabicArray);
    }

    private static int[] convertRomanToArabicArray(char[] romanArray) {
        int[] arabicArray = new int[romanArray.length];
        for (int i = 0; i < arabicArray.length; i++) {
            switch (romanArray[i]) {
                case 'M':
                    arabicArray[i] = 1000;
                    break;
                case 'D':
                    arabicArray[i] = 500;
                    break;
                case 'C':
                    arabicArray[i] = 100;
                    break;
                case 'L':
                    arabicArray[i] = 50;
                    break;
                case 'X':
                    arabicArray[i] = 10;
                    break;
                case 'V':
                    arabicArray[i] = 5;
                    break;
                case 'I':
                    arabicArray[i] = 1;
                    break;
                default:
                    break;
            }
        }
        for (int i = arabicArray.length - 1; i > 0; i--) {
            if (arabicArray[i] > arabicArray[i - 1]) {
                arabicArray[i - 1] = -arabicArray[i - 1];
            }
        }
        return arabicArray;
    }

    private static int getArabicValue(int[] arabicArray) {
        int arabicValue = 0;
        for (int i = 0; i < arabicArray.length; i++) {
            int i1 = arabicArray[i];
            arabicValue += i1;
        }
        return arabicValue;
    }
}
