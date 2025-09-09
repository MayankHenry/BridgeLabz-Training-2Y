import java.util.Scanner;
import java.util.Arrays;

public class AdvancedNumberFactors {

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
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));

        if (factors.length > 0) {
            long sum = 0;
            long product = 1;
            double productOfCubes = 1.0;
            int greatestFactor = factors[factors.length - 1];

            for (int factor : factors) {
                sum += factor;
                product *= factor;
                productOfCubes *= Math.pow(factor, 3);
            }
            
            System.out.println("Greatest Factor (the number itself): " + greatestFactor);
            System.out.println("Sum of factors: " + sum);
            System.out.println("Product of factors: " + product);
            System.out.println("Product of the cube of factors: " + productOfCubes);
        } else {
            System.out.println("No factors found.");
        }
    }
}