public class MainGrocery {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice");
        Product apples = new Product("Apples", 2, 3); // 2 kg at $3/kg
        Product milk = new Product("Milk", 1, 2); // 1 liter at $2/liter
        alice.addProduct(apples); alice.addProduct(milk);
        BillGenerator bg = new BillGenerator();
        System.out.println(bg.generateBill(alice));
    }
}