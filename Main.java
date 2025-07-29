
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== BANKING SYSTEM MENU ====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");1
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    system.createAccount();
                    break;
                case 2:
                    system.deposit();
                    break;
                case 3:
                    system.withdraw();
                    break;
                case 4:
                    system.checkBalance();
                    break;
                case 5:
                    system.displayAccount();
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking System.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);
    }
}
