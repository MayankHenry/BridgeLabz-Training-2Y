import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();
        
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();
        
        System.out.print("Enter Time period (in years): ");
        double time = sc.nextDouble();
        
        double interest = calculateSimpleInterest(principal, rate, time);
        
        System.out.println("The Simple Interest is " + interest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
        
        sc.close();
    }
    
    static double calculateSimpleInterest(double principal, double rate, double time) {
        return principal * rate * time / 100;
    }
}