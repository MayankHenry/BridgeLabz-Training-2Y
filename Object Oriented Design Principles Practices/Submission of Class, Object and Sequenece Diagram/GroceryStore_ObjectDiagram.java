public class GroceryStore_ObjectDiagram {
	public static void main(String[] args) {
		String customer = "customer1:Customer{name=\"Alice\"}";
		String apples = "product1:Product{name=\"Apples\", qty=2, unitPrice=3}";
		String milk = "product2:Product{name=\"Milk\", qty=1, unitPrice=2}";
		System.out.println(customer);
		System.out.println(apples);
		System.out.println(milk);
		System.out.println("customer1 -- contains --> product1, product2");
	}
}
