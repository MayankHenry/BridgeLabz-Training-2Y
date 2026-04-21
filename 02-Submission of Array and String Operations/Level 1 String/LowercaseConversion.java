import java.util.Scanner;

public class LowercaseConversion {
    static String convertToLowercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
    
    static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String userDefined = convertToLowercase(text);
        String builtin = text.toLowerCase();
        
        boolean result = compareStrings(userDefined, builtin);
        
        System.out.println("User-defined lowercase: " + userDefined);
        System.out.println("Built-in toLowerCase(): " + builtin);
        System.out.println("Results are equal: " + result);
        
        sc.close();
    }
}
