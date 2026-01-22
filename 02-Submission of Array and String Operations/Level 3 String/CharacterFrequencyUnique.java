import java.util.Scanner;

public class CharacterFrequencyUnique {
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
    
    static char[] findUniqueCharacters(String text) {
        int len = findLength(text);
        char[] unique = new char[len];
        int uniqueCount = 0;
        
        for (int i = 0; i < len; i++) {
            boolean isUnique = true;
            
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                unique[uniqueCount] = text.charAt(i);
                uniqueCount++;
            }
        }
        
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        
        return result;
    }
    
    static String[][] findCharacterFrequencyUnique(String text, char[] unique) {
        int len = findLength(text);
        int[] frequency = new int[256];
        
        for (int i = 0; i < len; i++) {
            frequency[text.charAt(i)]++;
        }
        
        String[][] result = new String[unique.length][2];
        
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        char[] unique = findUniqueCharacters(text);
        String[][] freq = findCharacterFrequencyUnique(text, unique);
        
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + "\t\t" + freq[i][1]);
        }
        
        sc.close();
    }
}
