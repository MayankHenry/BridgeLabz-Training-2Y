import java.util.Scanner;

public class SubstringComparison {
    static String createSubstring(String text, int startIndex, int endIndex) {
        String result = "";
        for (int i = startIndex; i < endIndex; i++) {
            result += text.charAt(i);
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
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        System.out.print("Enter start index: ");
        int startIndex = sc.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = sc.nextInt();
        
        String userDefined = createSubstring(text, startIndex, endIndex);
        String builtin = text.substring(startIndex, endIndex);
        
        boolean result = compareStrings(userDefined, builtin);
        
        System.out.println("User-defined substring: " + userDefined);
        System.out.println("Built-in substring(): " + builtin);
        System.out.println("Substrings are equal: " + result);
        
        sc.close();
    }
}
