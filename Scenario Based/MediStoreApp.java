import java.time.LocalDate;

interface ISellable {
    boolean sell(int qty);
    void checkExpiry();
}

class Medicine implements ISellable {
    protected String name;
    private double price;
    private LocalDate expiryDate;
    private int quantity;

    Medicine(String n, double p, LocalDate exp, int q){
        name=n; price=p; expiryDate=exp; quantity=q;
    }

    public double getPrice(){ return price; }
    protected void adjustStock(int qtyChange){ quantity+=qtyChange; }

    public boolean sell(int qty){
        if(qty<=quantity){ quantity-=qty; System.out.println(qty+" sold of "+name); return true; }
        System.out.println("Insufficient stock for "+name); return false;
    }

    public void checkExpiry(){
        if(expiryDate.isBefore(LocalDate.now())) System.out.println(name+" expired!");
        else System.out.println(name+" valid until "+expiryDate);
    }

    public int getQuantity(){ return quantity; }
}

class Tablet extends Medicine {
    Tablet(String n,double p,LocalDate exp,int q){ super(n,p,exp,q); }
    public void checkExpiry(){ super.checkExpiry(); System.out.println("Tablet checked."); }
}

class Syrup extends Medicine {
    Syrup(String n,double p,LocalDate exp,int q){ super(n,p,exp,q); }
    public void checkExpiry(){ super.checkExpiry(); System.out.println("Syrup checked."); }
}

class Injection extends Medicine {
    Injection(String n,double p,LocalDate exp,int q){ super(n,p,exp,q); }
    public void checkExpiry(){ super.checkExpiry(); System.out.println("Injection checked."); }
}

public class MediStoreApp {
    public static void main(String[] args){
        Medicine m1=new Tablet("Paracetamol",50,LocalDate.of(2026,5,1),100);
        Medicine m2=new Syrup("Cough Syrup",120,LocalDate.of(2025,12,1),50);
        Medicine m3=new Injection("Vitamin B12",200,LocalDate.of(2024,10,10),30);

        m1.sell(10); m1.checkExpiry();
        m2.sell(5); m2.checkExpiry();
        m3.sell(2); m3.checkExpiry();

        System.out.println("Stock remaining: "+m1.getQuantity()+" "+m2.getQuantity()+" "+m3.getQuantity());
    }
}
