import java.util.Scanner;

public class LargestSecondLargestDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        long temp = number;
        while (temp != 0) {
            if (index == maxDigit) {
                maxDigit = maxDigit * 2;
                int[] tempArray = new int[maxDigit];
                for (int i = 0; i < index; i++) {
                    tempArray[i] = digits[i];
                }
                digits = tempArray;
            }
            
            int digit = (int)(temp % 10);
            digits[index] = digit;
            temp = temp / 10;
            index++;
        }
        
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        sc.close();
    }
}
