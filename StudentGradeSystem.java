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
            else if (choice == 2) {
                System.out.println("\nList of Students and Grades:");
                if (studentCount == 0) {
                    System.out.println("No records found.");
                } else {
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println(studentNames[i] + " - " + studentGrades[i]);
                    }
                }
            }
            else if (choice == 3) {
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
            else if (choice == 4) {
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
            else if (choice == 5) {
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
        input.close();
    }
}