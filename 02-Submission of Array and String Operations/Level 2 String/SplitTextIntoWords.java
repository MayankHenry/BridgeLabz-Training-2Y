import java.util.Scanner;

public class SplitTextIntoWords {
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
    
    static boolean compareStringArrays(String[] arr1, String[] arr2) {
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String[] userDefined = splitWords(text);
        String[] builtin = text.split(" ");
        
        boolean result = compareStringArrays(userDefined, builtin);
        
        System.out.println("User-defined split: ");
        for (String word : userDefined) {
            System.out.print(word + " ");
        }
        System.out.println();
        
        System.out.println("Built-in split(): ");
        for (String word : builtin) {
            System.out.print(word + " ");
        }
        System.out.println();
        
        System.out.println("Results are equal: " + result);
        
        sc.close();
    }
}
