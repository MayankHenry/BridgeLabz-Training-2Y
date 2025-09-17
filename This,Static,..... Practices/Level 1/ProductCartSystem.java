public class ProductCartSystem {
    public static void main(String[] args) {
        Product.updateDiscount(10.0);
        Product p1 = new Product("Headphones", 2000.0, 2, "P-100");
        Object ref = p1;
        if (ref instanceof Product) {
            ((Product) ref).process();
        }
        Product.updateDiscount(15.0);
        p1.process();
    }
}

class Product {
    static double discount;
    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double percent) {
        discount = percent;
    }

    void process() {
        double total = price * quantity;
        double discounted = total - (total * discount / 100.0);
        System.out.println("Product: " + productName + ", ID: " + productID + ", Qty: " + quantity + ", Total: " + discounted + " @" + discount + "%");
    }
}


