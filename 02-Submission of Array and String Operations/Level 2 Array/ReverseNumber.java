import java.util.Scanner;

public class ReverseNumber {
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
        
        int[] reversed = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversed[i] = digits[digitCount - 1 - i];
        }
        
        System.out.print("Reversed number: ");
        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i]);
        }
        System.out.println();
        
        sc.close();
    }
}
