public class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;

    public BankAccount(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit sucessful.New balance:₹" + balance);
        }
            else
            {
            System.out.println("incorrect amount");
        }
        }
        public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: ₹" + balance);
        }else{
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    public void display() {
         System.out.println("-- Account Details --");
         System.out.println("Account Number : " + accountNumber);
         System.out.println("Balance :₹"+balance);
}
}
