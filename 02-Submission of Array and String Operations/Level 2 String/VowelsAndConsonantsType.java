import java.util.Scanner;

public class VowelsAndConsonantsType {
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
    
    static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkVowelConsonant(text.charAt(i));
        }
        
        return result;
    }
    
    static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        System.out.println("---------\t-----------");
        
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String[][] charTypes = getCharacterTypes(text);
        
        displayTable(charTypes);
        
        sc.close();
    }
}
