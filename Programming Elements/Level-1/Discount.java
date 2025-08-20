
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
        System.out.println("The discount amount is INR " + discountFee + " and final discounted fee is INR" + finalFee);
        scanner.close();
    }
}
