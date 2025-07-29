
import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        BankAccount account = new BankAccount(accNum, name);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public BankAccount findAccount(String accNum) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        return null;
    }

    public void deposit() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amt = sc.nextDouble();
            sc.nextLine();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amt = sc.nextDouble();
            sc.nextLine();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            System.out.println("Current Balance: ₹" + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAccount() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account not found.");
        }
    }
}
