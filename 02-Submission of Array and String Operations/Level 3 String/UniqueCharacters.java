import java.util.Scanner;

public class UniqueCharacters {
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        char[] uniqueChars = findUniqueCharacters(text);
        
        System.out.println("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
