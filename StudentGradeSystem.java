import java.util.Scanner;

/**
 * Project: Student Grade Management System
 * Developer: Abdulaziz Gholoum
 * Description: A menu-driven system to store and analyze student grades using 1D arrays.
 */
public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Parallel 1D arrays to store student information
        // Constraints: Maximum of 50 students
        String[] studentNames = new String[50];
        int[] studentGrades = new int[50];
        int studentCount = 0; // Tracks the current number of student records stored
        
        int choice = 0;

        // Main program loop
        while (choice != 6) {
            // Display the system menu
            System.out.println("\nWelcome to Student Grade Management System");
            System.out.println("1. Add Student and Grade");
            System.out.println("2. Display All Students and Grades");
            System.out.println("3. Find a Student's Grade");
            System.out.println("4. Calculate Class Average");
            System.out.println("5. Find Highest and Lowest Grades");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            // Validate that the user input is an integer
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Clear the newline character from the buffer
            } else {
                System.out.println("Invalid input!");
                input.nextLine(); // Clear invalid non-integer input
                continue;
            }

            // Process user choice using a switch statement
            switch (choice) {
                case 1:
                    // Check if the array has reached its maximum capacity
                    if (studentCount >= 50) {
                        System.out.println("Capacity reached! Cannot add more students.");
                    } else {
                        System.out.print("Enter student name: ");
                        String name = input.nextLine();
                        System.out.print("Enter student grade: ");
                        int grade = input.nextInt();
                        
                        // Validate grade range (0-100) before saving
                        if (grade >= 0 && grade <= 100) {
                            studentNames[studentCount] = name;
                            studentGrades[studentCount] = grade;
                            studentCount++;
                            System.out.println("Student added successfully!");
                        } else {
                            System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                        }
                    }
                    break;

                case 2:
                    // Loop through the arrays and display all stored records
                    System.out.println("\nList of Students and Grades:");
                    if (studentCount == 0) {
                        System.out.println("No records found.");
                    } else {
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println(studentNames[i] + " - " + studentGrades[i]);
                        }
                    }
                    break;

                case 3:
                    // Search for a specific student's grade by name (case-insensitive)
                    System.out.print("Enter student name: ");
                    String searchName = input.nextLine();
                    boolean found = false;
                    
                    for (int i = 0; i < studentCount; i++) {
                        if (studentNames[i].equalsIgnoreCase(searchName)) {
                            System.out.println(studentNames[i] + "'s Grade: " + studentGrades[i]);
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Calculate and display the average grade of the class
                    if (studentCount == 0) {
                        System.out.println("Class Average: 0.0");
                    } else {
                        double sum = 0;
                        for (int i = 0; i < studentCount; i++) {
                            sum += studentGrades[i];
                        }
                        double average = sum / studentCount;
                        System.out.println("Class Average: " + average);
                    }
                    break;

                case 5:
                    // Find and display the students with the highest and lowest grades
                    if (studentCount == 0) {
                        System.out.println("No students available.");
                    } else {
                        int highestIdx = 0;
                        int lowestIdx = 0;

                        for (int i = 1; i < studentCount; i++) {
                            if (studentGrades[i] > studentGrades[highestIdx]) {
                                highestIdx = i;
                            }
                            if (studentGrades[i] < studentGrades[lowestIdx]) {
                                lowestIdx = i;
                            }
                        }
                        System.out.println("Highest Grade: " + studentNames[highestIdx] + " - " + studentGrades[highestIdx]);
                        System.out.println("Lowest Grade: " + studentNames[lowestIdx] + " - " + studentGrades[lowestIdx]);
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    // Handle choices outside of 1-6
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                    break;
            }
        }
        input.close();
    }
}