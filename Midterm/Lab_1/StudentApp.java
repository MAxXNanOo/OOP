import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        System.out.print("Enter number of students: ");
        int num = scanner.nextInt();
        scanner.nextLine();  // clear buffer

        for (int i = 1; i <= num; i++) {
            System.out.println("\nEnter Student " + i + " Info:");

            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();  // clear buffer

            Student student = new Student(id, name, age, gpa);
            manager.addStudent(student);
        }

        manager.showAllStudents();
        System.out.println("Total Passed Students: " + manager.countPassedStudents());

        scanner.close();
    }
} 
