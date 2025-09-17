public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount.bankName = "Global Bank";
        BankAccount a1 = new BankAccount("Alice", 1001);
        BankAccount a2 = new BankAccount("Bob", 1002);
        Object ref = a1;
        if (ref instanceof BankAccount) {
            ((BankAccount) ref).displayDetails();
        }
        a2.displayDetails();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}

class BankAccount {
    static String bankName;
    private static int totalAccounts;
    final int accountNumber;
    String accountHolderName;

    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    void displayDetails() {
        System.out.println("Bank: " + bankName + ", Holder: " + accountHolderName + ", Account#: " + accountNumber);
    }
}


