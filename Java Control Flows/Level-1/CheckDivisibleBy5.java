import java.util.Scanner;

public class CheckDivisibleBy5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number % 5 == 0) {
            System.out.println("Is the number divisible by 5?" + number + " Yes.");
        } else {
            System.out.println("Is the number divisible by 5?" + number + " No");
        }
        scanner.close();
    }
}