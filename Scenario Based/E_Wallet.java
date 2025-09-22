interface Transferrable { void transferTo(User r,double amt); }

class Transaction {
    private String details;
    Transaction(String d){ details=d; }
    public String toString(){ return details; }
}

abstract class Wallet implements Transferrable {
    private double balance; 
    private String[] history=new String[100]; 
    private int hCount=0;

    Wallet(double init){ balance=init; }
    double getBalance(){ return balance; }
    void load(double amt){ balance+=amt; add("Loaded "+amt); }
    protected void update(double amt,String msg){ balance+=amt; add(msg); }
    private void add(String msg){ history[hCount++]=msg; }
    void showHistory(){
        for(int i=0;i<hCount;i++) System.out.println(history[i]);
    }
}

class PersonalWallet extends Wallet {
    PersonalWallet(double init){ super(init); }
    public void transferTo(User r,double amt){
        if(amt<=getBalance() && amt<=5000){
            update(-amt,"Sent "+amt+" to "+r.getName());
            r.getWallet().update(amt,"Received "+amt+" from "+r.getName());
        }
    }
}

class BusinessWallet extends Wallet {
    BusinessWallet(double init){ super(init); }
    public void transferTo(User r,double amt){
        double tax=amt*0.02;
        if(amt+tax<=getBalance()){
            update(-(amt+tax),"Business Sent "+amt+"+Tax "+tax+" to "+r.getName());
            r.getWallet().update(amt,"Received "+amt+" from "+r.getName());
        }
    }
}

class User {
    private String name; private Wallet wallet;
    User(String n,boolean business,boolean referral){
        double bonus=referral?100:0;
        wallet= business? new BusinessWallet(bonus): new PersonalWallet(bonus);
        name=n;
    }
    String getName(){ return name; }
    Wallet getWallet(){ return wallet; }
}

public class E_Wallet {
    public static void main(String[] a){
        User u1=new User("Amit",false,true);
        User u2=new User("Riya",true,false);

        u1.getWallet().load(2000);
        u1.getWallet().transferTo(u2,1000);
        u2.getWallet().transferTo(u1,500);

        System.out.println("Amit Balance: "+u1.getWallet().getBalance());
        u1.getWallet().showHistory();

        System.out.println("Riya Balance: "+u2.getWallet().getBalance());
        u2.getWallet().showHistory();
    }
}
