public class Multilevel_OrderManagement {
	public static void main(String[] args) {
		Order o1 = new Order("ORD001", "2025-09-15");
		Order o2 = new ShippedOrder("ORD002", "2025-09-14", "TRK12345");
		Order o3 = new DeliveredOrder("ORD003", "2025-09-13", "TRK67890", "2025-09-15");

		Order[] orders = {o1, o2, o3};
		for (Order o : orders) {
			System.out.println("Order ID: " + o.orderId);
			System.out.println("Order Date: " + o.orderDate);
			System.out.println("Status: " + o.getOrderStatus());
			if (o instanceof ShippedOrder) {
				System.out.println("Tracking: " + ((ShippedOrder) o).trackingNumber);
			}
			if (o instanceof DeliveredOrder) {
				System.out.println("Delivery Date: " + ((DeliveredOrder) o).deliveryDate);
			}
			System.out.println("---");
		}
	}
}

class Order {
	String orderId;
	String orderDate;

	Order(String orderId, String orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	String getOrderStatus() {
		return "Order Placed";
	}
}

class ShippedOrder extends Order {
	String trackingNumber;

	ShippedOrder(String orderId, String orderDate, String trackingNumber) {
		super(orderId, orderDate);
		this.trackingNumber = trackingNumber;
	}

	@Override
	String getOrderStatus() {
		return "Shipped";
	}
}

class DeliveredOrder extends ShippedOrder {
	String deliveryDate;

	DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
		super(orderId, orderDate, trackingNumber);
		this.deliveryDate = deliveryDate;
	}

	@Override
	String getOrderStatus() {
		return "Delivered";
	}
}
