
import java.util.Scanner;

public class CompleteTextToUpperCaseAndCompareResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        String upperCaseString = input.toUpperCase();
        boolean isEqual = input.equals(upperCaseString);
        System.out.println("Uppercase String: " + upperCaseString);
        System.out.println("Is original string equal to uppercase string? " + isEqual);
    }
}
