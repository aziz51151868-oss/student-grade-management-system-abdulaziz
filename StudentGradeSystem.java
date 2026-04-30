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
            
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); 
            } else {
                System.out.println("Invalid input!");
                input.nextLine(); 
                continue;
            }

            if (choice == 1) {
                // Check if the array is full
                if (studentCount >= 50) {
                    System.out.println("Capacity reached! Cannot add more students.");
                } else {
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    System.out.print("Enter student grade: ");
                    int grade = input.nextInt();
                    
                    // Grade range validation
                    if (grade >= 0 && grade <= 100) {
                        studentNames[studentCount] = name;
                        studentGrades[studentCount] = grade;
                        studentCount++;
                    } else {
                        System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                    }
                }
            }
        }
        input.close();
    }
}