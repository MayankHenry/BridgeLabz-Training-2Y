import java.util.*;

interface Discountable {
	double applyDiscount(double amount);
	String getDiscountDetails();
}

abstract class FoodItem {
	private String itemName;
	private double price;
	private int quantity;

	public FoodItem(String itemName, double price, int quantity) {
		this.itemName = itemName;
		setPrice(price);
		setQuantity(quantity);
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) return;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) return;
		this.quantity = quantity;
	}

	public String getItemDetails() {
		return itemName + " x" + quantity + " @ " + price;
	}

	public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
	public VegItem(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
	}

	@Override
	public double calculateTotalPrice() {
		return getPrice() * getQuantity();
	}

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.90;
	}

	@Override
	public String getDiscountDetails() {
		return "10% veg discount";
	}
}

class NonVegItem extends FoodItem implements Discountable {
	public NonVegItem(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
	}

	@Override
	public double calculateTotalPrice() {
		double base = getPrice() * getQuantity();
		return base + base * 0.10;
	}

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.95;
	}

	@Override
	public String getDiscountDetails() {
		return "5% non-veg discount";
	}
}

public class OnlineFoodDeliverySystem {
	public static void main(String[] args) {
		List<FoodItem> order = new ArrayList<>();
		order.add(new VegItem("Paneer Tikka", 250, 2));
		order.add(new NonVegItem("Chicken Biryani", 300, 1));

		double total = 0;
		for (FoodItem item : order) {
			double line = item.calculateTotalPrice();
			if (item instanceof Discountable) {
				line = ((Discountable) item).applyDiscount(line);
			}
			total += line;
			System.out.println(item.getItemDetails() + " => " + line);
		}
		System.out.println("Total: " + total);
	}
}
