import java.util.*;

interface Taxable {
	double calculateTax();
	String getTaxDetails();
}

abstract class Product {
	private String productId;
	private String name;
	private double price;

	public Product(String productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		setPrice(price);
	}

	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) return;
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) return;
		this.price = price;
	}

	public abstract double calculateDiscount();
}

class Electronics extends Product implements Taxable {
	public Electronics(String productId, String name, double price) {
		super(productId, name, price);
	}

	@Override
	public double calculateDiscount() {
		return getPrice() * 0.10;
	}

	@Override
	public double calculateTax() {
		return (getPrice() - calculateDiscount()) * 0.18;
	}

	@Override
	public String getTaxDetails() {
		return "18% GST";
	}
}

class Clothing extends Product implements Taxable {
	public Clothing(String productId, String name, double price) {
		super(productId, name, price);
	}

	@Override
	public double calculateDiscount() {
		return getPrice() * 0.20;
	}

	@Override
	public double calculateTax() {
		return (getPrice() - calculateDiscount()) * 0.05;
	}

	@Override
	public String getTaxDetails() {
		return "5% GST";
	}
}

class Groceries extends Product {
	public Groceries(String productId, String name, double price) {
		super(productId, name, price);
	}

	@Override
	public double calculateDiscount() {
		return getPrice() * 0.05;
	}
}

public class ECommercePlatform {
	public static double finalPrice(Product p) {
		double discount = p.calculateDiscount();
		double base = p instanceof Product ? ((Product) p).getPrice() : 0;
		double tax = p instanceof Taxable ? ((Taxable) p).calculateTax() : 0;
		return base + tax - discount;
	}

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Electronics("P001", "Phone", 50000));
		products.add(new Clothing("P002", "Shirt", 2000));
		products.add(new Groceries("P003", "Rice", 1000));

		for (Product p : products) {
			double price = finalPrice(p);
			System.out.println(p.getName() + ": " + price);
		}
	}
}
