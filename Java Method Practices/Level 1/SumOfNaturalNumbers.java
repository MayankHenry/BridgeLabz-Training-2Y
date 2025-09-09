import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        int sum = calculateSum(n);
        
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);
        
        sc.close();
    }
    
    static int calculateSum(int n) {
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        
        return sum;
    }
}