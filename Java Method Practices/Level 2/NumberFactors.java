import java.util.Scanner;
import java.util.Arrays;

public class NumberFactors {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);
        System.out.println("Factors of " + number + " are: " + Arrays.toString(factors));

        long sum = 0;
        long sumOfSquares = 0;
        long product = 1;

        for (int factor : factors) {
            sum += factor;
            sumOfSquares += Math.pow(factor, 2);
            product *= factor;
        }

        System.out.println("Sum of factors: " + sum);
        System.out.println("Sum of squares of factors: " + sumOfSquares);
        System.out.println("Product of factors: " + product);

        scanner.close();
    }
}