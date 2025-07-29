import java.io.*;
import java.util.Scanner;
public class Admin {
    private static final String TIMETABLE_FILE = "timetable.txt";
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin123";
    public static void login(Scanner sc) {
        System.out.print("Enter Admin Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();
        if (username.equals(ADMIN_USER) && password.equals(ADMIN_PASS)) {
            System.out.println("Admin Login Successful!");
            adminMenu(sc);
        } else {
            System.out.println("Invalid credentials.");
        }
    }
    private static void adminMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Timetable");
            System.out.println("2. Add Timetable Entry");
            System.out.println("3. Delete Timetable Entry");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: viewTimetable(); break;
                case 2: addEntry(sc); break;
                case 3: deleteEntry(sc); break;
                case 4: System.out.println("Logging out..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
    private static void viewTimetable() {
        try (BufferedReader br = new BufferedReader(new FileReader(TIMETABLE_FILE))) {
            String line;
            System.out.println("\n--- Current Timetable ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Timetable file not found or error reading it.");
        }
    }
    private static void addEntry(Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TIMETABLE_FILE, true))) {
            System.out.print("Enter Day (e.g., Monday): ");
            String day = sc.nextLine();
            System.out.print("Enter Time (e.g., 10:00 AM - 11:00 AM): ");
            String time = sc.nextLine();
            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();
            System.out.print("Enter Teacher Name: ");
            String teacher = sc.nextLine();
            String entry = day + " | " + time + " | " + subject + " | " + teacher;
            bw.write(entry);
            bw.newLine();
            System.out.println("Entry added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to timetable file.");
        }
    }
    private static void deleteEntry(Scanner sc) {
        try {
            File inputFile = new File(TIMETABLE_FILE);
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            System.out.print("Enter subject name to delete entry: ");
            String toDelete = sc.nextLine();
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (!line.toLowerCase().contains(toDelete.toLowerCase())) {
                    writer.write(line + System.lineSeparator());
                } else {
                    found = true;
                }
            }
            writer.close();
            reader.close();
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
                if (found) {
                    System.out.println("Entry deleted.");
                } else {
                    System.out.println("No matching entry found.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error deleting entry.");
        }
    }
}
