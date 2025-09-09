import java.util.ArrayList;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;
    private static ArrayList<CartItem> cart = new ArrayList<>();

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void addItem(String itemName, double price, int quantity) {
        CartItem item = new CartItem(itemName, price, quantity);
        cart.add(item);
        System.out.println(itemName + " added to cart.");
    }

    public static void removeItem(String itemName) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equals(itemName)) {
                cart.remove(i);
                System.out.println(itemName + " removed from cart.");
                return;
            }
        }
        System.out.println(itemName + " not found in cart.");
    }

    public static double calculateTotalCost() {
        double totalCost = 0.0;
        for (CartItem item : cart) {
            totalCost += item.price * item.quantity;
        }
        return totalCost;
    }

    public static void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        
        System.out.println("Shopping Cart:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Item", "Price", "Quantity", "Subtotal");
        System.out.println("--------------------------------------------------");
        
        for (CartItem item : cart) {
            double subtotal = item.price * item.quantity;
            System.out.printf("%-20s $%-9.2f %-10d $%-9.2f%n", 
                    item.itemName, item.price, item.quantity, subtotal);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("%-41s $%-9.2f%n", "Total Cost:", calculateTotalCost());
    }

    public static void main(String[] args) {
        addItem("Laptop", 999.99, 1);
        addItem("Mouse", 29.99, 2);
        addItem("Keyboard", 49.99, 1);
        
        displayCart();
        
        removeItem("Mouse");
        
        displayCart();
    }
}