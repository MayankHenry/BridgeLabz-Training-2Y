import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println(text.charAt(text.length() + 5));
    }
    
    static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println(text.charAt(text.length() + 5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: Index out of range");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        System.out.println("Generating StringIndexOutOfBoundsException:");
        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception generated: " + e.getClass().getName());
        }
        
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleStringIndexOutOfBoundsException(text);
        
        sc.close();
    }
}
