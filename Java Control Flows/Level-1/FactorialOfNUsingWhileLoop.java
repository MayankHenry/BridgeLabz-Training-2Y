import java.util.Scanner;

public class FactorialOfNUsingWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer (n): ");
        int n = input.nextInt();
        if (n > 0) {
            long factorial = 1;
            int i = 1;
            while (i <= n) {
                factorial *= i;
                i++;
            }
            System.out.println("The factorial of " + n + " is: " + factorial);
        } else {
            System.out.println("Error: Please enter a positive integer (a natural number).");
        }
    }
}
