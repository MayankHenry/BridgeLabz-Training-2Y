import java.util.*;

class Account {
	private String accountNumber;
	private double balance;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) return;
		balance += amount;
	}
}

class Customer {
	private String name;
	private List<Account> accounts = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void viewBalance() {
		System.out.println("Customer: " + name);
		for (Account a : accounts) {
			System.out.println(a.getAccountNumber() + ": " + a.getBalance());
		}
	}
}

class Bank {
	private String name;
	private List<Customer> customers = new ArrayList<>();

	public Bank(String name) {
		this.name = name;
	}

	public Customer openAccount(String customerName, String accountNumber) {
		Customer customer = findOrCreateCustomer(customerName);
		Account account = new Account(accountNumber);
		customer.addAccount(account);
		return customer;
	}

	private Customer findOrCreateCustomer(String name) {
		for (Customer c : customers) {
			if (c.getName().equals(name)) return c;
		}
		Customer c = new Customer(name);
		customers.add(c);
		return c;
	}
}

public class BankAndAccountHolders_Association {
	public static void main(String[] args) {
		Bank bank = new Bank("ABC Bank");
		Customer c1 = bank.openAccount("Rita", "A001");
		Customer c2 = bank.openAccount("Rita", "A002");
		Customer c3 = bank.openAccount("Mohan", "A003");
		c1.viewBalance();
		c3.viewBalance();
	}
}
