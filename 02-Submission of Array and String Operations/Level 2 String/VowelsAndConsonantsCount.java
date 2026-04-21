import java.util.Scanner;

public class VowelsAndConsonantsCount {
    static String checkVowelConsonant(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else if ((ch >= 'a' && ch <= 'z')) {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }
    
    static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        
        for (int i = 0; i < text.length(); i++) {
            String type = checkVowelConsonant(text.charAt(i));
            
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        
        return new int[]{vowels, consonants};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        int[] counts = countVowelsConsonants(text);
        
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        
        sc.close();
    }
}
