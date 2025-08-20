import java.util.Scanner;

public class UnitandQuantityToTotalPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the unit price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.println("The total price is: " + totalPrice);
        scanner.close();
    }
}
