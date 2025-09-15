class GS_Customer {
	public double checkout(GS_BillGenerator gen) { return gen.total(this); }
}

class GS_Product { }

class GS_BillGenerator {
	public double total(GS_Customer c) { return 11.0; }
}

public class GroceryStore_SequenceDiagram {
	public static void main(String[] args) {
		GS_Customer customer = new GS_Customer();
		GS_BillGenerator gen = new GS_BillGenerator();
		System.out.println("Customer -> BillGenerator: checkout()");
		double total = customer.checkout(gen);
		System.out.println("BillGenerator --> Customer: " + total);
	}
}
