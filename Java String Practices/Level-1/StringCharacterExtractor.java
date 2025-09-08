import java.util.Arrays;
import java.util.Scanner;

public class StringCharacterExtractor {
    public static char[] getCharsFromString(String str) {
        if (str == null) {
            return new char[0];
        }
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == arr2;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputText = scanner.next();
        scanner.close();

        char[] userDefinedArray = getCharsFromString(inputText);
        char[] builtInArray = inputText.toCharArray();

        boolean areArraysEqual = compareCharArrays(userDefinedArray, builtInArray);
        System.out.println("User-defined method result: " + Arrays.toString(userDefinedArray));
        System.out.println("Built-in toCharArray() result: " + Arrays.toString(builtInArray));
        System.out.println("\nAre the two character arrays identical? " + areArraysEqual);
    }
}