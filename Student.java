import java.io.*;
import java.util.Scanner;
public class Student {
    public static void login(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + "!");
        boolean running = true;
        while (running) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View Full Timetable");
            System.out.println("2. View Timetable by Day");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: viewTimetable(); break;
                case 2:
                    System.out.print("Enter day (e.g., Monday): ");
                    String day = sc.nextLine();
                    viewByDay(day); break;
                case 3: running = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    private static void viewTimetable() {
        try (BufferedReader br = new BufferedReader(new FileReader("timetable.txt"))) {
            String line;
            System.out.println("\n--- Weekly Timetable ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Timetable file not found.");
        }
    }
    private static void viewByDay(String day) {
        try (BufferedReader br = new BufferedReader(new FileReader("timetable.txt"))) {
            String line;
            System.out.println("\n--- " + day + "'s Classes ---");
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().startsWith(day.toLowerCase())) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No classes found for " + day);
            }
        } catch (IOException e) {
            System.out.println("Error reading timetable.");
        }
    }
}
