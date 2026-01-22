import java.util.Scanner;

public class StringComparison {
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
        
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        
        boolean userDefined = compareStrings(str1, str2);
        boolean builtin = str1.equals(str2);
        
        System.out.println("User-defined comparison: " + userDefined);
        System.out.println("Built-in equals() method: " + builtin);
        System.out.println("Results match: " + (userDefined == builtin));
        
        sc.close();
    }
}
