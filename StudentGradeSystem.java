import java.util.Scanner;

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Parallel 1D arrays to store student information
        // Constraints: Max 50 students
        String[] studentNames = new String[50];
        int[] studentGrades = new int[50];
        int studentCount = 0; // Tracks how many students have been added
        
        int choice = 0;

        while (choice != 6) {
            // Polished menu based on project requirements
            System.out.println("\nWelcome to Student Grade Management System");
            System.out.println("1. Add Student and Grade");
            System.out.println("2. Display All Students and Grades");
            System.out.println("3. Find a Student's Grade");
            System.out.println("4. Calculate Class Average");
            System.out.println("5. Find Highest and Lowest Grades");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            // Basic error handling for non-integer menu choices
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Clear the newline character from the buffer
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                input.nextLine(); // Clear the invalid input
                continue;
            }

            // Implementation for choices will go here
            if (choice == 1) {
                // Logic for adding students will be in the next step
            }
        }
        
        System.out.println("Exiting the program. Goodbye!");
        input.close();
    }
}