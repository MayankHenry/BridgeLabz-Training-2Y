import java.util.Scanner;

public class PowerOfNumberWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();
        
        System.out.print("Enter the power (positive integer): ");
        int power = scanner.nextInt();
        
        if (power < 0) {
            System.out.println("Please enter a positive power!");
        } else {
            int result = 1;
            int counter = 0;
            
            while (counter < power) {
                result *= number;
                counter++;
            }
            
            System.out.println(number + " raised to power " + power + " is: " + result);
        }
        
        scanner.close();
    }
}