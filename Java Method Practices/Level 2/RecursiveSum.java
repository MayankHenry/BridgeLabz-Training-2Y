import java.util.Scanner;

public class RecursiveSum {

    public static int sumByRecursion(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumByRecursion(n - 1);
    }

    public static int sumByFormula(int n) {
        if (n <= 0) {
            return 0;
        }
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Please enter a positive natural number.");
        } else {
            int recursiveResult = sumByRecursion(number);
            int formulaResult = sumByFormula(number);

            System.out.println("Sum using recursion: " + recursiveResult);
            System.out.println("Sum using formula: " + formulaResult);

            if (recursiveResult == formulaResult) {
                System.out.println("Both results match.");
            } else {
                System.out.println("Results do not match.");
            }
        }
        scanner.close();
    }
}