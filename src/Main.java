import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AttendanceSystem attendanceSystem = new AttendanceSystem();
        SchoolManagementApp attendanceAdapter = new AttendanceSystemAdapter(attendanceSystem);

        GradingSystem gradingSystem = new GradingSystem();
        SchoolManagementApp gradingAdapter = new GradingSystemAdapter(gradingSystem);

        LibrarySystem librarySystem = new LibrarySystem();
        SchoolManagementApp libraryAdapter = new LibrarySystemAdapter(librarySystem);

        System.out.println("WELCOME TO UNIFIED SCHOOL MANAGEMENT APPLICATION!\n");

        int choice;

        do {
            System.out.println("Please select a system: ");
            System.out.println("1. Attendance System");
            System.out.println("2. Grading System");
            System.out.println("3. Library System");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(attendanceAdapter.integrateSystem());
                    break;
                case 2:
                    System.out.println(gradingAdapter.integrateSystem());
                    break;
                case 3:
                    System.out.println(libraryAdapter.integrateSystem());
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a number between 1 and 4.\n");
            }
        } while (choice != 4);

        scanner.close();
    }
}