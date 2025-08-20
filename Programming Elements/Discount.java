
import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter University Fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter Discount: ");
        double discount = scanner.nextDouble();
        double discountFee = fee * (discount / 100);
        double finalFee = fee - discountFee;
        System.out.println("Final Fee after discount is: " + finalFee);
        scanner.close();
    }
}
