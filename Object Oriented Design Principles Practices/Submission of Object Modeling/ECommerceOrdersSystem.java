import java.util.*;

class ProductItem {
	private String name;
	private double price;

	public ProductItem(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}

class Order {
	private String orderId;
	private List<ProductItem> products = new ArrayList<>();

	public Order(String orderId) {
		this.orderId = orderId;
	}

	public void addProduct(ProductItem p) {
		products.add(p);
	}

	public double getTotal() {
		double sum = 0;
		for (ProductItem p : products) sum += p.getPrice();
		return sum;
	}

	public void printSummary() {
		System.out.println("Order: " + orderId);
		for (ProductItem p : products) {
			System.out.println(p.getName() + " - " + p.getPrice());
		}
		System.out.println("Total: " + getTotal());
	}
}

class CustomerUser {
	private String name;
	private List<Order> orders = new ArrayList<>();

	public CustomerUser(String name) {
		this.name = name;
	}

	public Order placeOrder(String orderId) {
		Order o = new Order(orderId);
		orders.add(o);
		return o;
	}

	public void showOrders() {
		System.out.println("Customer: " + name);
		for (Order o : orders) {
			o.printSummary();
		}
	}
}

public class ECommerceOrdersSystem {
	public static void main(String[] args) {
		CustomerUser c = new CustomerUser("Ritika");
		Order o1 = c.placeOrder("O1001");
		Order o2 = c.placeOrder("O1002");
		ProductItem p1 = new ProductItem("Phone", 50000);
		ProductItem p2 = new ProductItem("Headphones", 3000);
		ProductItem p3 = new ProductItem("Book", 500);
		o1.addProduct(p1);
		o1.addProduct(p2);
		o2.addProduct(p3);
		c.showOrders();
	}
}
