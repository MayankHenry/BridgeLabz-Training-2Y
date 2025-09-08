import java.util.Arrays;
import java.util.Scanner;

public class WordSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        scanner.close();
        String[] customSplitResult = splitTextIntoWords(text);
        String[] builtinSplitResult = text.trim().split("\\s+");
        if (text.trim().isEmpty()) {
           builtinSplitResult = new String[0];
        }
        boolean areIdentical = compareStringArrays(customSplitResult, builtinSplitResult);
        System.out.println("Custom split result: " + Arrays.toString(customSplitResult));
        System.out.println("Built-in split result: " + Arrays.toString(builtinSplitResult));
        System.out.println("Are the results identical? " + areIdentical);
    }
    public static int findStringLength(String str) {
        int i = 0;
        try {
            for (i = 0; ; i++) {
                str.charAt(i);
            }
        } catch (Exception e) {
            return i;
        }
    }
    public static String[] splitTextIntoWords(String text) {
        text = text.trim();
        if (findStringLength(text) == 0) {
            return new String[0];
        }
        text = text + " ";
        int wordCount = 0;
        for (int i = 0; i < findStringLength(text); i++) {
            if (text.charAt(i) == ' ' && i > 0 && text.charAt(i-1) != ' ') {
                 wordCount++;
            }
        }
        String[] words = new String[wordCount];
        String currentWord = "";
        int wordIndex = 0;
        for (int i = 0; i < findStringLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (findStringLength(currentWord) > 0) {
                    if(wordIndex < wordCount) {
                        words[wordIndex] = currentWord;
                        wordIndex++;
                    }
                    currentWord = "";
                }
            }
        }
        return words;
    }
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}