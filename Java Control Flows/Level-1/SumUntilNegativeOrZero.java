import java.util.Scanner;

public class SumUntilNegativeOrZero {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a positive number (0 or negative to stop): ");
            double number = input.nextDouble();
            
            if (number <= 0) {
                System.out.println("Stopping the calculation...");
                break; 
            }
            total += number;
        }
        System.out.println("The final sum is: " + total);
        input.close();
    }
}
