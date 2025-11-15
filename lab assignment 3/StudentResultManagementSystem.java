import java.util.InputMismatchException;
import java.util.Scanner;

// Custom exception class for invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Student class
class Student {
    private int rollNumber;
    private String name;
    private int[] marks;

    // Constructor
    public Student(int rollNumber, String name, int[] marks) throws InvalidMarksException {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Student name cannot be null or empty.");
        }
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
        validateMarks();
    }

    // Validate marks range (0–100)
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + marks[i]);
            }
        }
    }

    // Calculate average marks
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    // Display student result
    public void displayResult() {
        double average = calculateAverage();
        String result = average >= 40 ? "Pass" : "Fail";

        System.out.println("\n--- Student Result ---");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);

        System.out.print("Marks       : ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nAverage     : " + average);
        System.out.println("Result      : " + result);
    }
}

// Main class
public class StudentResultManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("===== Student Result Management System =====");
            System.out.print("Enter Roll Number: ");
            int rollNumber = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            int[] marks = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student student = new Student(rollNumber, name, marks);
            student.displayResult();

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter numeric values for roll number and marks.");
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            System.out.println("\nProgram execution completed. Resources closed.");
            sc.close();
        }
    }
}
