import java.util.Scanner;

public class StringLengthWithoutMethod {
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        int userDefined = findLength(text);
        int builtin = text.length();
        
        System.out.println("User-defined length: " + userDefined);
        System.out.println("Built-in length(): " + builtin);
        System.out.println("Results are equal: " + (userDefined == builtin));
        
        sc.close();
    }
}
