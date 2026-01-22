import java.util.Scanner;

public class ShortestLongestWords {
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
    
    static int[] findShortestLongest(String[][] wordsWithLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int minLen = Integer.parseInt(wordsWithLengths[0][1]);
        int maxLen = Integer.parseInt(wordsWithLengths[0][1]);
        
        for (int i = 1; i < wordsWithLengths.length; i++) {
            int len = Integer.parseInt(wordsWithLengths[i][1]);
            
            if (len < minLen) {
                minLen = len;
                shortestIndex = i;
            }
            
            if (len > maxLen) {
                maxLen = len;
                longestIndex = i;
            }
        }
        
        return new int[]{shortestIndex, longestIndex};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String[] words = splitWords(text);
        String[][] wordsWithLengths = getWordsWithLengths(words);
        int[] indexes = findShortestLongest(wordsWithLengths);
        
        System.out.println("Shortest word: " + wordsWithLengths[indexes[0]][0] + " (Length: " + Integer.parseInt(wordsWithLengths[indexes[0]][1]) + ")");
        System.out.println("Longest word: " + wordsWithLengths[indexes[1]][0] + " (Length: " + Integer.parseInt(wordsWithLengths[indexes[1]][1]) + ")");
        
        sc.close();
    }
}
