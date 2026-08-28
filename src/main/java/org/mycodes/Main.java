package org.mycodes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentService service = new StudentService();

        System.out.println("======STUDENT MANAGEMENT SYSTEM======");

        int choice;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit Application");

            System.out.println();
            System.out.print("Enter Choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = in.nextLine();
                    System.out.print("Enter Student Email: ");
                    String email = in.nextLine();
                    System.out.print("Enter Student Course: ");
                    String course = in.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = in.nextDouble();

                    Student student = new Student(name, email, course, marks);
                    service.insertStudent(student);

                    break;
                case 2:
                    service.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student Id: ");
                    int searchId = in.nextInt();
                    service.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student Id: ");
                    int upId = in.nextInt();
                    service.updateStudent(upId);
                    break;

                case 5:
                    System.out.print("Enter Student Id: ");
                    int delId = in.nextInt();
                    service.deleteStudent(delId);
                    break;
                case 6:
                    System.out.println("Application Closed");
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }
        while (choice != 6);
    }
}
