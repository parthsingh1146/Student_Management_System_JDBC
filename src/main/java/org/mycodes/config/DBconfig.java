package org.mycodes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconfig {
    static String url = "jdbc:mysql://localhost:3306/jdbc_project01";
    static String username = "root";
    static String password = "sql123";

    public static Statement getInstance() throws SQLException {
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        return st;
    }
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
