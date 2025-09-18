import java.util.ArrayList;
import java.util.List;
public class Customer {
    private String name;
    private List<Product> cart = new ArrayList<>();
    public Customer(String name){ this.name = name; }
    public void addProduct(Product p){ cart.add(p); }
    public double getTotal(){
        double sum = 0;
        for(Product p: cart) sum += p.getTotalPrice();
        return sum;
    }
    public String getName(){ return name; }
    public List<Product> getCart(){ return cart; }
}