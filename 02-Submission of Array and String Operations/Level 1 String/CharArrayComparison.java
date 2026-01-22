import java.util.Scanner;

public class CharArrayComparison {
    static char[] getCharacters(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }
    
    static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        char[] userDefined = getCharacters(text);
        char[] builtin = text.toCharArray();
        
        boolean result = compareCharArrays(userDefined, builtin);
        
        System.out.println("User-defined character array: ");
        for (char c : userDefined) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        System.out.println("Built-in toCharArray(): ");
        for (char c : builtin) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        System.out.println("Arrays are equal: " + result);
        
        sc.close();
    }
}
