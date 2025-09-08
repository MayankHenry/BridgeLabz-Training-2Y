import java.util.ArrayList;
import java.util.Scanner;

public class SimplifiedWordsAndLengths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        scanner.close();
        String[] words = splitTextIntoWords(text);
        String[][] wordsAndLengths = createWordsAndLengthsArray(words);
        System.out.println("Word Length");
        for (String[] pair : wordsAndLengths) {
            System.out.printf("%-17s | %d%n", pair[0], Integer.parseInt(pair[1]));
        }
    }
    public static int findStringLength(String str) {
        int i = 0;
        try {
            for (i = 0; ; i++) str.charAt(i);
        } catch (Exception e) {
            return i;
        }
    }
    public static String[] splitTextIntoWords(String text) {
        ArrayList<String> wordList = new ArrayList<>();
        String currentWord = "";
        for (int i = 0; i < findStringLength(text); i++) {
            if (text.charAt(i) != ' ') {
                currentWord += text.charAt(i);
            } else {
                if (findStringLength(currentWord) > 0) {
                    wordList.add(currentWord);
                }
                currentWord = "";
            }
        }
        if (findStringLength(currentWord) > 0) {
            wordList.add(currentWord);
        }
        return wordList.toArray(new String[0]);
    }
    public static String[][] createWordsAndLengthsArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findStringLength(words[i]));
        }
        return result;
    }
}