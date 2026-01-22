import java.util.Scanner;

public class NumbersWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = sc.nextDouble();
            
            if (num <= 0) {
                break;
            }
            
            if (index == 10) {
                break;
            }
            
            numbers[index] = num;
            index++;
        }
        
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
        
        System.out.println("Sum of all numbers: " + total);
        
        sc.close();
    }
}
