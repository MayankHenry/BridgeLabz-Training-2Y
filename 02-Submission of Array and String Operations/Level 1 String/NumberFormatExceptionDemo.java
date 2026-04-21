import java.util.Scanner;

public class NumberFormatExceptionDemo {
    static void generateNumberFormatException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }
    
    static void handleNumberFormatException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Text does not contain a valid integer");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        System.out.println("Generating NumberFormatException:");
        try {
            generateNumberFormatException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception generated: " + e.getClass().getName());
        }
        
        System.out.println("\nHandling NumberFormatException:");
        handleNumberFormatException(text);
        
        sc.close();
    }
}
