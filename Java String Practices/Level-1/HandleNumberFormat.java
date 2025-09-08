import java.util.Scanner;

public class HandleNumberFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        scanner.close();
        try {
            int number = Integer.parseInt(input);
            System.out.println("You entered the number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught a NumberFormatException: Invalid number format for input '" + input + "'");
        }
    }
}
