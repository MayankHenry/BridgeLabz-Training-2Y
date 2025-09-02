import java.util.Scanner;

class PartialTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] multiplicationResult = new int[4]; 
        int arrayIndex = 0;

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[arrayIndex] = number * i;
            arrayIndex++;
        }
        
        System.out.println("\nMultiplication table for " + number + " from 6 to 9:");
        arrayIndex = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[arrayIndex]);
            arrayIndex++;
        }
        input.close();
    }
}