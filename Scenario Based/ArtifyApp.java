interface IPurchasable {
    boolean purchase(User buyer);
    void license();
}

class User {
    private String name;
    private double walletBalance;

    User(String n, double balance){ name=n; walletBalance=balance; }

    public boolean deduct(double amount){
        if(walletBalance>=amount){ walletBalance-=amount; return true; }
        System.out.println("Insufficient funds for "+name); return false;
    }

    public double getBalance(){ return walletBalance; }
    public String getName(){ return name; }
}

abstract class Artwork implements IPurchasable {
    protected String title, artist;
    protected double price;
    protected String licenseType;

    Artwork(String t, String a, double p, String l){
        title=t; artist=a; price=p; licenseType=l;
    }

    public boolean purchase(User buyer){
        if(buyer.deduct(price)){ 
            System.out.println(buyer.getName()+" purchased "+title+" by "+artist); 
            return true; 
        }
        return false;
    }

    public abstract void license();
}

class DigitalArt extends Artwork {
    DigitalArt(String t,String a,double p,String l){ super(t,a,p,l); }
    public void license(){ System.out.println(title+" licensed digitally under "+licenseType); }
}

class PrintArt extends Artwork {
    PrintArt(String t,String a,double p,String l){ super(t,a,p,l); }
    public void license(){ System.out.println(title+" licensed physically under "+licenseType); }
}

public class ArtifyApp {
    public static void main(String[] args){
        User u1=new User("Amit",1000);
        Artwork d1=new DigitalArt("Sunset","Artist A",300,"Personal Use");
        Artwork p1=new PrintArt("Mountain","Artist B",500,"Commercial Use");

        d1.purchase(u1); d1.license();
        p1.purchase(u1); p1.license();

        System.out.println("Remaining balance: "+u1.getBalance());
    }
}
