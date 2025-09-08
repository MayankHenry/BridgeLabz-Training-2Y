
import java.util.Scanner;

public class SubstringFromStringUsingCharAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter the starting index: ");
        int startIndex = scanner.nextInt();
        System.out.print("Enter the ending index: ");
        int endIndex = scanner.nextInt();
        scanner.close();
        if (startIndex < 0 || endIndex > str.length() || startIndex >= endIndex) {
            System.out.println("Invalid indices");
            return;
        }
        StringBuilder substring = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            substring.append(str.charAt(i));
        }
        System.out.println("Substring: " + substring.toString());
    }
}
