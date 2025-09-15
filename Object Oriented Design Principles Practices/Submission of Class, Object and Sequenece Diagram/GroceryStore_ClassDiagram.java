import java.util.*;

class Product {
	private String name;
	private double unitPrice;
	private double quantity;

	public Product(String name, double unitPrice, double quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return unitPrice * quantity;
	}
}

class Customer {
	private String name;
	private List<Product> cart = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addProduct(Product p) {
		cart.add(p);
	}

	public List<Product> getCart() {
		return cart;
	}
}

class BillGenerator {
	public double generateTotal(Customer c) {
		double sum = 0;
		for (Product p : c.getCart()) sum += p.getCost();
		return sum;
	}
}

public class GroceryStore_ClassDiagram {
	public static void main(String[] args) {
		Customer alice = new Customer("Alice");
		alice.addProduct(new Product("Apples", 3, 2));
		alice.addProduct(new Product("Milk", 2, 1));
		BillGenerator bg = new BillGenerator();
		System.out.println("Total: " + bg.generateTotal(alice));
	}
}
