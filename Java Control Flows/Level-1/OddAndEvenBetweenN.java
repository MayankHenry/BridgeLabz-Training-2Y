import java.util.Scanner;

public class OddAndEvenBetweenN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (n): ");
        int n = scanner.nextInt();
        if (n > 0) {
            System.out.println("Even numbers between 1 and " + n + ":");
            for (int i = 2; i <= n; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println("\nOdd numbers between 1 and " + n + ":");
            for (int i = 1; i <= n; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("Error: Please enter a positive integer (a natural number).");
        }
    }
}
