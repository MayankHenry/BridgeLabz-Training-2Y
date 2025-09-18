public class BillGenerator {
    public String generateBill(Customer c){
        StringBuilder sb = new StringBuilder();
        sb.append("Bill for ").append(c.getName()).append("\n");
        for(Product p: c.getCart()){
            sb.append(p.getName()).append(": ").append(p.getTotalPrice()).append("\n");
        }
        sb.append("Total: ").append(c.getTotal());
        return sb.toString();
    }
}