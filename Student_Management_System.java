import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(id + " - " + name + " - " + marks);
    }
}

public class Student_Management_System {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter Marks: ");
            double marks = input.nextDouble();

            students.add(new Student(id, name, marks));

            System.out.println("Student added!");
        }
        catch (Exception e) {
            System.out.println("Invalid input!");
            input.nextLine();
        }
    }

    static void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = input.nextInt();

                if (choice == 1) {
                    addStudent();
                }
                else if (choice == 2) {
                    viewStudents();
                }
                else if (choice == 3) {
                    System.out.println("Thank you!");
                    break;
                }
                else {
                    System.out.println("Invalid choice!");
                }

            }
            catch (Exception e) {
                System.out.println("Please enter a number!");
                input.nextLine();
            }
        }

        input.close();
    }
}