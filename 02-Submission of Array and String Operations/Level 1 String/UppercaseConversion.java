import java.util.Scanner;

public class UppercaseConversion {
    static String convertToUppercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
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
        
        String userDefined = convertToUppercase(text);
        String builtin = text.toUpperCase();
        
        boolean result = compareStrings(userDefined, builtin);
        
        System.out.println("User-defined uppercase: " + userDefined);
        System.out.println("Built-in toUpperCase(): " + builtin);
        System.out.println("Results are equal: " + result);
        
        sc.close();
    }
}
