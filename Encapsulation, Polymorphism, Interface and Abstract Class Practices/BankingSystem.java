import java.util.*;

interface Loanable {
	boolean applyForLoan(double amount);
	double calculateLoanEligibility();
}

abstract class BankAccountBase {
	private String accountNumber;
	private String holderName;
	private double balance;

	public BankAccountBase(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = Math.max(balance, 0);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) return;
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0 || amount > balance) return;
		balance -= amount;
	}

	public abstract double calculateInterest();
}

class SavingsAccount extends BankAccountBase implements Loanable {
	public SavingsAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public double calculateInterest() {
		return getBalance() * 0.04;
	}

	@Override
	public boolean applyForLoan(double amount) {
		return amount <= getBalance() * 2;
	}

	@Override
	public double calculateLoanEligibility() {
		return getBalance() * 2;
	}
}

class CurrentAccount extends BankAccountBase implements Loanable {
	public CurrentAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public double calculateInterest() {
		return getBalance() * 0.01;
	}

	@Override
	public boolean applyForLoan(double amount) {
		return amount <= getBalance();
	}

	@Override
	public double calculateLoanEligibility() {
		return getBalance();
	}
}

public class BankingSystem {
	public static void main(String[] args) {
		List<BankAccountBase> accounts = new ArrayList<>();
		accounts.add(new SavingsAccount("SB001", "Rahul", 50000));
		accounts.add(new CurrentAccount("CA001", "Priya", 120000));

		for (BankAccountBase a : accounts) {
			System.out.println(a.getHolderName() + " Interest: " + a.calculateInterest());
			if (a instanceof Loanable) {
				Loanable l = (Loanable) a;
				System.out.println("Eligibility: " + l.calculateLoanEligibility());
				System.out.println("Loan 60000: " + l.applyForLoan(60000));
			}
			System.out.println("---");
		}
	}
}
