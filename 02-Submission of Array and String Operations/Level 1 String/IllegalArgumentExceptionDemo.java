import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    static void generateIllegalArgumentException(String text) {
        System.out.println(text.substring(5, 2));
    }
    
    static void handleIllegalArgumentException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: Start index greater than end index");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        System.out.println("Generating IllegalArgumentException:");
        try {
            generateIllegalArgumentException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception generated: " + e.getClass().getName());
        }
        
        System.out.println("\nHandling IllegalArgumentException:");
        handleIllegalArgumentException(text);
        
        sc.close();
    }
}
