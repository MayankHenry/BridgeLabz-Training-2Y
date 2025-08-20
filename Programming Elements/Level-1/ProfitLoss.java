import java.util.Scanner;

public class ProfitLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the cost price: ");
        double costPrice = scanner.nextDouble();
        System.out.print("Enter the selling price: ");
        double sellingPrice = scanner.nextDouble();

        if(sellingPrice>costPrice){
            System.out.println("The Profit is INR " + (sellingPrice - costPrice) + "and the profit percentage is " + ((sellingPrice - costPrice) / costPrice * 100));
        } else if(sellingPrice<costPrice){
            System.out.println("The Cost Price is INR " + costPrice + "and the Selling Price is INR " + sellingPrice);
        } else {
            System.out.println("No Profit No Loss");    
        }
        scanner.close();
    }
}
