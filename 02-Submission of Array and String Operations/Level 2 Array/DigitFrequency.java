import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        
        long temp = number;
        int digitCount = 0;
        
        while (temp != 0) {
            digitCount++;
            temp = temp / 10;
        }
        
        int[] digits = new int[digitCount];
        temp = number;
        int index = 0;
        
        while (temp != 0) {
            digits[index] = (int)(temp % 10);
            temp = temp / 10;
            index++;
        }
        
        int[] frequency = new int[10];
        
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }
        
        System.out.println("Digit frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
        
        sc.close();
    }
}
