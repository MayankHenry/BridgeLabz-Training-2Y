import java.util.Scanner;

public class CompleteTextToLowerCaseAndCompareResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        String lowerCaseString = input.toLowerCase();
        boolean isEqual = input.equals(lowerCaseString);
        System.out.println("Lowercase String: " + lowerCaseString);
        System.out.println("Is original string equal to lowercase string? " + isEqual);
    }
}