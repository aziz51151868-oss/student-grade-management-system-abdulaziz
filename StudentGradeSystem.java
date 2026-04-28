import java.util.Scanner;

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n--- Student Grade System ---");
            System.out.println("1. Add Student\n2. Display All\n3. Search\n4. Average\n5. High/Low\n6. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
        }
    }
}