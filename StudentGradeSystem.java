import java.util.Scanner;

/**
 * Project: Student Grade Management System
 * Developer: Abdulaziz Gholoum
 * Description: A menu-driven system to store and analyze student grades using 1D arrays and functions.
 */
public class StudentGradeSystem {
    static Scanner input = new Scanner(System.in);
    
    // Parallel 1D arrays to store student information
    // Constraints: Maximum of 50 students
    static String[] studentNames = new String[50];
    static int[] studentGrades = new int[50];
    
    // Tracks the current number of student records stored
    static int studentCount = 0; 

    // --------------------------------------------------------
    // MAIN METHOD - Program Entry Point
    // --------------------------------------------------------
    public static void main(String[] args) {
        int choice = 0;

        // Main program loop
        while (choice != 6) {
            displayMenu();
            
            // Validate that the user input is an integer
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Clear the newline character from the buffer
            } else {
                System.out.println("Invalid input!");
                input.nextLine(); // Clear invalid non-integer input
                continue;
            }

            // Process user choice by calling the appropriate function
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    findHighestAndLowest();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                    break;
            }
        }
        input.close();
    }

    // --------------------------------------------------------
    // HELPER FUNCTIONS
    // --------------------------------------------------------

    /**
     * Displays the main menu options to the user.
     */
    public static void displayMenu() {
        System.out.println("\nWelcome to Student Grade Management System");
        System.out.println("1. Add Student and Grade");
        System.out.println("2. Display All Students and Grades");
        System.out.println("3. Find a Student's Grade");
        System.out.println("4. Calculate Class Average");
        System.out.println("5. Find Highest and Lowest Grades");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles adding a new student name and grade to the parallel arrays.
     * Validates capacity and grade range.
     */
    public static void addStudent() {
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
    }

    /**
     * Loops through the arrays and prints all currently stored student records.
     */
    public static void displayAllStudents() {
        System.out.println("\nList of Students and Grades:");
        if (studentCount == 0) {
            System.out.println("No records found.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println(studentNames[i] + " - " + studentGrades[i]);
            }
        }
    }

    /**
     * Searches for a student by name (case-insensitive) and prints their grade if found.
     */
    public static void searchStudent() {
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
    }

    /**
     * Calculates and displays the mathematical average of all stored grades.
     */
    public static void calculateAverage() {
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
    }

    /**
     * Iterates through the records to find and display the highest and lowest grades.
     */
    public static void findHighestAndLowest() {
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
    }
}