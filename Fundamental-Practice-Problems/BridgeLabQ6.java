
import java.util.Scanner;

public class BridgeLabQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float principal, rate, time, interest;
        System.out.print("Enter principal amount: ");   
        principal = sc.nextFloat();
        System.out.print("Enter rate of interest: ");
        rate = sc.nextFloat();
        System.out.print("Enter time in years: ");
        time = sc.nextFloat();
        interest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + interest);
        sc.close();
}
}