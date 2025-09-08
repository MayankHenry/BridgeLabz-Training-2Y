import java.util.Scanner;

public class CheckNullString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (or press Enter to input null): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            input = null;
        }
        scanner.close();
        try {
            int length = input.length();
            System.out.println("Length of the string: " + length);
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: The string is null.");
        }
    }
}
