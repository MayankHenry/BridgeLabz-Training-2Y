interface IDiscountable {
    double applyDiscount();
}

class Book implements IDiscountable {
    protected String title, author;
    protected double price;
    private int stock;

    Book(String t, String a, double p, int s){ title=t; author=a; price=p; stock=s; }

    public boolean sell(int qty){
        if(qty<=stock){ stock-=qty; return true; }
        return false;
    }

    public int getStock(){ return stock; }
    public double getPrice(){ return price; }
    public String getTitle(){ return title; }

    public double applyDiscount(){ return price; } // base no discount
}

class EBook extends Book {
    EBook(String t,String a,double p,int s){ super(t,a,p,s); }
    public double applyDiscount(){ return price*0.9; } // 10% off
}

class PrintedBook extends Book {
    PrintedBook(String t,String a,double p,int s){ super(t,a,p,s); }
    public double applyDiscount(){ return price*0.95; } // 5% off
}

class Order {
    private Book[] books = new Book[10];
    private int[] qty = new int[10];
    private int count=0;
    private String status="Pending"; // cannot be edited directly

    public void addBook(Book b,int q){ books[count]=b; qty[count]=q; count++; }

    public double calculateTotal(){
        double total=0;
        for(int i=0;i<count;i++)
            total+=books[i].applyDiscount()*qty[i];
        return total;
    }

    public void finalizeOrder(){ status="Completed"; System.out.println("Order Completed. Total: "+calculateTotal()); }
    public String getStatus(){ return status; }
}

public class BookBazaarApp {
    public static void main(String[] args){
        Book b1=new EBook("Java 101","Author A",500,100);
        Book b2=new PrintedBook("Python Basics","Author B",600,50);

        Order order=new Order();
        order.addBook(b1,2);
        order.addBook(b2,1);

        System.out.println("Total Cost: "+order.calculateTotal());
        order.finalizeOrder();
        System.out.println("Order Status: "+order.getStatus());
    }
}
