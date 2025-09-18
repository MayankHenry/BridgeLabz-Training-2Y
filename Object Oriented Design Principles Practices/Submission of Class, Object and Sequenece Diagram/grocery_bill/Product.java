public class Product {
    private String name;
    private double qty;
    private double pricePerUnit;
    public Product(String name, double qty, double pricePerUnit) {
        this.name = name; this.qty = qty; this.pricePerUnit = pricePerUnit;
    }
    public double getTotalPrice(){ return qty * pricePerUnit; }
    public String getName(){ return name; }
}