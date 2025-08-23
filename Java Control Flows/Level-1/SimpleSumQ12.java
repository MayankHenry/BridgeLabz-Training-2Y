import java.util.Scanner;

public class SimpleSumQ12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number = input.nextInt();
        if (number > 0) {
            long sumFromLoop = 0;
            int i = 1;
            while (i <= number) {
                sumFromLoop = sumFromLoop + i;
                i = i + 1;
            }
            long sumFromFormula = (long) number * (number + 1) / 2;
            System.out.println("Sum calculated by the loop: " + sumFromLoop);
            System.out.println("Sum calculated by the formula: " + sumFromFormula);
            if (sumFromLoop == sumFromFormula) {
                System.out.println("The results are the same!");
            } else {
                System.out.println("The results are different.");
            }
        } else {
            System.out.println("Please enter a positive number.");
        }
        input.close();
    }
}