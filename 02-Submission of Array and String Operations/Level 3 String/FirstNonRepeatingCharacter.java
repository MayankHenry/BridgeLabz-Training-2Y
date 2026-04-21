import java.util.Scanner;

public class FirstNonRepeatingCharacter {
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
    
    static char findFirstNonRepeating(String text) {
        int len = findLength(text);
        int[] frequency = new int[256];
        
        for (int i = 0; i < len; i++) {
            frequency[text.charAt(i)]++;
        }
        
        for (int i = 0; i < len; i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        
        return '\0';
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        char firstNonRep = findFirstNonRepeating(text);
        
        if (firstNonRep == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + firstNonRep);
        }
        
        sc.close();
    }
}
