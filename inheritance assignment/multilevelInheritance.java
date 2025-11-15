import java.util.Scanner;

// Base class
class Student {
    int rollNo;
    String name;
    String course;

    // Constructor to accept student details
    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    void displayStudentInfo() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Course  : " + course);
    }
}

// Derived class from Student
class Marks extends Student {
    int m1, m2, m3;

    // Constructor for Marks
    Marks(int rollNo, String name, String course, int m1, int m2, int m3) {
        super(rollNo, name, course);   // calling Student constructor
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    void displayMarks() {
        System.out.println("Marks in Subject 1 : " + m1);
        System.out.println("Marks in Subject 2 : " + m2);
        System.out.println("Marks in Subject 3 : " + m3);
    }
}

// Derived class from Marks
class Result extends Marks {
    int total;
    double percentage;
    char grade;

    // Constructor for Result
    Result(int rollNo, String name, String course, int m1, int m2, int m3) {
        super(rollNo, name, course, m1, m2, m3);  // calling Marks constructor
        calculate();
    }

    // Method to calculate total, percentage, and grade
    void calculate() {
        total = m1 + m2 + m3;
        percentage = total / 3.0;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 75) {
            grade = 'B';
        } else if (percentage >= 50) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    // Display result details
    void displayResult() {
        displayStudentInfo();
        displayMarks();
        System.out.println("Total Marks  : " + total);
        System.out.println("Percentage   : " + percentage + "%");
        System.out.println("Grade        : " + grade);
    }
}

// Main class
public class multilevelInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accepting student details
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // to consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        // Accepting marks
        System.out.print("Enter marks in Subject 1: ");
        int m1 = sc.nextInt();
        System.out.print("Enter marks in Subject 2: ");
        int m2 = sc.nextInt();
        System.out.print("Enter marks in Subject 3: ");
        int m3 = sc.nextInt();

        // Creating Result object
        Result res = new Result(roll, name, course, m1, m2, m3);

        // Display full student info with result
        System.out.println("\n----- Student Result -----");
        res.displayResult();

        sc.close();
    }
}
