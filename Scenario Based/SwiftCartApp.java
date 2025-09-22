interface ICheckout {
    double generateBill();
    double applyDiscount(double coupon);
}

abstract class Product {
    protected String name, category;
    protected double price;
    Product(String n, double p, String c){ name=n; price=p; category=c; }
    public double getPrice(){ return price; }
    public String getName(){ return name; }
}

class PerishableProduct extends Product {
    PerishableProduct(String n, double p){ super(n,p,"Perishable"); }
    public double discountedPrice(double coupon){ return price*0.9 - coupon; } // 10% perishable discount
}

class NonPerishableProduct extends Product {
    NonPerishableProduct(String n, double p){ super(n,p,"Non-Perishable"); }
    public double discountedPrice(double coupon){ return price - coupon; }
}

class Cart implements ICheckout {
    private Product[] products = new Product[10];
    private int count=0;
    private double totalPrice=0;

    Cart() {}
    Cart(Product[] items, int n){
        for(int i=0;i<n;i++) addProduct(items[i]);
    }

    public void addProduct(Product p){ if(count<10) products[count++]=p; }
    public double generateBill(){
        totalPrice=0;
        for(int i=0;i<count;i++) totalPrice+=products[i].getPrice();
        return totalPrice;
    }

    public double applyDiscount(double coupon){
        double discounted=0;
        for(int i=0;i<count;i++){
            if(products[i] instanceof PerishableProduct)
                discounted+=((PerishableProduct)products[i]).discountedPrice(coupon);
            else
                discounted+=((NonPerishableProduct)products[i]).discountedPrice(coupon);
        }
        return discounted;
    }

    public void showCart(){
        for(int i=0;i<count;i++) System.out.println(products[i].getName()+" - "+products[i].getPrice());
    }
}

public class SwiftCartApp {
    public static void main(String[] args){
        Product p1=new PerishableProduct("Milk",50);
        Product p2=new NonPerishableProduct("Soap",30);
        Product p3=new PerishableProduct("Cheese",80);

        Cart cart=new Cart();
        cart.addProduct(p1); cart.addProduct(p2); cart.addProduct(p3);

        cart.showCart();
        System.out.println("Total Bill: "+cart.generateBill());
        System.out.println("Discounted Bill: "+cart.applyDiscount(10));
    }
}
