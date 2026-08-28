package org.mycodes;

import org.mycodes.config.DBconfig;

import java.sql.*;
import java.util.Scanner;

public class StudentService {
    public void insertStudent(Student student){

        String sql = """
                INSERT INTO students(name,email,course,marks) values (?,?,?,?)
                """;

        try {
            Connection con = DBconfig.getConnection();
            PreparedStatement pq = con.prepareStatement(sql);
            pq.setString(1,student.getName());
            pq.setString(2,student.getEmail());
            pq.setString(3,student.getCourse());
            pq.setDouble(4,student.getMarks());
            int row = pq.executeUpdate();
            if(row>0){
                System.out.println("Student added Successfully");
            }
            pq.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }

    public void viewAllStudents(){
        String sql = """
                SELECT * from students
                """;

        try {
            Connection con = DBconfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            System.out.println("Student Record");
            System.out.println("-----------------------------------");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");
                double marks = resultSet.getDouble("marks");
                System.out.println("Id: "+ id+" Name: "+name+" Email: "+email+" Course: " +course+ " Marks: "+marks);
            }
            resultSet.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }

    public void searchStudent(int id){
        String sql = """
                SELECT * from students where id = ?
                """;
        try {
            Connection con = DBconfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                System.out.println();
                System.out.println("Student Found");

                System.out.println("Id: "+ resultSet.getInt("id"));
                System.out.println("Name: "+ resultSet.getString("name"));
                System.out.println("Email: "+ resultSet.getString("email"));
                System.out.println("Course: "+ resultSet.getString("course"));
                System.out.println("Marks: "+ resultSet.getDouble("marks"));
            }
            else {
                System.out.println("Student not found");
            }
            resultSet.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void updateStudent(int id) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose Detail you want to Update: ");
        System.out.println("1. Update name");
        System.out.println("2. Update email");
        System.out.println("3. Update course");
        System.out.println("4. Update marks");

        int choice = in.nextInt();
        in.nextLine();
        switch (choice){
            case 1:
                String sql = """
                        UPDATE students
                        SET name = ?
                        WHERE id = ?;
                        """;
                System.out.println("Enter new Name: ");
                String newName = in.nextLine();
                try {
                    Connection con = DBconfig.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,newName);
                    ps.setInt(2,id);
                    int row = ps.executeUpdate();
                    if(row>0){
                        System.out.println("Name updated Successfully");
                    }else{
                        System.out.println("Updation Failed");
                    }
                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error: "+e.getMessage());
                }

                break;
            case 2:
                String sql2 = """
                        UPDATE students
                        SET email = ?
                        WHERE id = ?;
                        """;
                System.out.println("Enter new Email: ");
                String newEmail = in.nextLine();
                try {
                    Connection con = DBconfig.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql2);
                    ps.setString(1, newEmail);
                    ps.setInt(2,id);
                    int row = ps.executeUpdate();
                    if(row>0){
                        System.out.println("Email updated Successfully");
                    }else{
                        System.out.println("Updation Failed");
                    }
                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error: "+e.getMessage());
                }
                break;

            case 3:
                String sql3 = """
                        UPDATE students
                        SET course = ?
                        WHERE id = ?;
                        """;
                System.out.println("Enter new Course: ");
                String newCourse = in.nextLine();
                try {
                    Connection con = DBconfig.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql3);
                    ps.setString(1, newCourse);
                    ps.setInt(2,id);
                    int row = ps.executeUpdate();
                    if(row>0){
                        System.out.println("Course updated Successfully");
                    }else{
                        System.out.println("Updation Failed");
                    }
                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            case 4:
                String sql4 = """
                        UPDATE students
                        SET marks = ?
                        WHERE id = ?;
                        """;
                System.out.println("Enter new marks: ");
                double newMarks = in.nextDouble();
                try {
                    Connection con = DBconfig.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql4);
                    ps.setDouble(1,newMarks);
                    ps.setInt(2,id);
                    int row = ps.executeUpdate();
                    if(row>0){
                        System.out.println("Marks updated Successfully");
                    }else{
                        System.out.println("Updation Failed");
                    }

                    ps.close();
                    con.close();

                } catch (SQLException e) {
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            default:
                System.out.println("Enter valid choice");
        }
    }

    public void deleteStudent(int id){
        String sql = """
                DELETE FROM students
                WHERE id = ?;
                """;
        try {
            Connection con = DBconfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            int row = ps.executeUpdate();
            if(row>0){
                System.out.println("Student Deleted Successfully");
            }else{
                System.out.println("Deletion Failed!");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
