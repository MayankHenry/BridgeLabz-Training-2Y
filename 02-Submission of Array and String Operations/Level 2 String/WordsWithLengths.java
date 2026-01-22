import java.util.Scanner;

public class WordsWithLengths {
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    static String[] splitWords(String text) {
        int len = findLength(text);
        int[] spaceIndexes = new int[len];
        int spaceCount = 0;
        
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }
        
        String[] words = new String[spaceCount + 1];
        int wordIndex = 0;
        int startIndex = 0;
        
        for (int i = 0; i < spaceCount; i++) {
            String word = "";
            for (int j = startIndex; j < spaceIndexes[i]; j++) {
                word += text.charAt(j);
            }
            words[wordIndex] = word;
            wordIndex++;
            startIndex = spaceIndexes[i] + 1;
        }
        
        String lastWord = "";
        for (int i = startIndex; i < len; i++) {
            lastWord += text.charAt(i);
        }
        words[wordIndex] = lastWord;
        
        return words;
    }
    
    static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String[] words = splitWords(text);
        String[][] wordsWithLengths = getWordsWithLengths(words);
        
        System.out.println("Word\t\tLength");
        System.out.println("----\t\t------");
        for (int i = 0; i < wordsWithLengths.length; i++) {
            System.out.println(wordsWithLengths[i][0] + "\t\t" + Integer.parseInt(wordsWithLengths[i][1]));
        }
        
        sc.close();
    }
}
