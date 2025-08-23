import java.util.Scanner;

public class SumWithForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer (n): ");
        int n = input.nextInt();
        if (n > 0) {
            long sumForLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumForLoop += i;
            }
            long sumFormula = (long) n * (n + 1) / 2;
            System.out.println("Result from the for loop: " + sumForLoop);
            System.out.println("Result from the formula n*(n+1)/2: " + sumFormula);
            if (sumForLoop == sumFormula) {
                System.out.println("Verification successful! The results match.");
            } else {
                System.out.println("Verification failed! The results do not match.");
            }
        } else {
            System.out.println("Error: Please enter a positive integer (a natural number).");
        }
        input.close();
    }
}
