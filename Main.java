import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n== Student Timetable ==");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: Admin.login(sc); break;
                case 2: Student.login(sc); break;
                case 3: running = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}