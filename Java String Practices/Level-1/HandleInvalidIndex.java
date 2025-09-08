import java.util.Scanner;

// The class has been renamed to avoid conflict with the built-in java.lang.IllegalArgumentException
public class HandleInvalidIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        System.out.print("Enter an index to access: ");
        int index = scanner.nextInt();
        scanner.close();
        try {
            if (index < 0 || index >= str.length()) {
                throw new IllegalArgumentException("Index " + index + " is out of bounds for string of length " + str.length());
            }
            char ch = str.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException: " + e.getMessage());
        }
    }
}