interface ITransaction {
    void deposit(double amt);
    void withdraw(double amt);
    double checkBalance();
}

abstract class Account implements ITransaction {
    private String accNo;
    private double balance;

    public Account(String accNo, double bal) {
        this.accNo = accNo;
        this.balance = bal;
    }
    public Account(String accNo) { this(accNo, 0); }

    public void deposit(double amt) { balance += amt; }
    public void withdraw(double amt) { if (amt <= balance) balance -= amt; }
    public double checkBalance() { return balance; }

    protected double getBalance() { return balance; }
    public abstract double calculateInterest();
}

class SavingsAccount extends Account {
    public SavingsAccount(String accNo, double bal) { super(accNo, bal); }
    public double calculateInterest() { return getBalance() * 4 / 100; }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accNo, double bal) { super(accNo, bal); }
    public double calculateInterest() { return getBalance() * 2 / 100; }
}

public class MyBank {
    public static void main(String[] args) {
        Account s = new SavingsAccount("SA123", 1000);
        s.deposit(500); s.withdraw(200);
        System.out.println("Savings Bal=" + s.checkBalance() + " Interest=" + s.calculateInterest());

        Account c = new CurrentAccount("CA456", 2000);
        c.deposit(1000); c.withdraw(500);
        System.out.println("Current Bal=" + c.checkBalance() + " Interest=" + c.calculateInterest());
    }
}
