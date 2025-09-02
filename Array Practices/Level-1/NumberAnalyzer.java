import java.util.Scanner;

class NumberAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 integer numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is a positive and even number.");
                } else {
                    System.out.println(num + " is a positive and odd number.");
                }
            } else if (num < 0) {
                System.out.println(num + " is a negative number.");
            } else {
                System.out.println(num + " is zero.");
            }
        }
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];
        if (firstElement > lastElement) {
            System.out.println("\nThe first element (" + firstElement + ") is greater than the last element (" + lastElement + ").");
        } else if (firstElement < lastElement) {
            System.out.println("\nThe first element (" + firstElement + ") is less than the last element (" + lastElement + ").");
        } else {
            System.out.println("\nThe first element (" + firstElement + ") is equal to the last element (" + lastElement + ").");
        }
        input.close();
    }
}