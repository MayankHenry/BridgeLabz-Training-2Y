import java.util.Scanner;

public class NumberAnalyzer {

    public static void analyzeNumber(int num) {
        if (num > 0) {
            System.out.print(num + " is positive and ");
            if (num % 2 == 0) {
                System.out.println("even.");
            } else {
                System.out.println("odd.");
            }
        } else if (num < 0) {
            System.out.println(num + " is negative.");
        } else {
            System.out.println(num + " is zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Analysis ---");
        for (int number : numbers) {
            analyzeNumber(number);
        }

        System.out.println("\n--- Comparison ---");
        int first = numbers[0];
        int last = numbers[4];

        if (first > last) {
            System.out.println("The first element (" + first + ") is greater than the last (" + last + ").");
        } else if (first < last) {
            System.out.println("The first element (" + first + ") is less than the last (" + last + ").");
        } else {
            System.out.println("The first element (" + first + ") is equal to the last (" + last + ").");
        }
        scanner.close();
    }
}