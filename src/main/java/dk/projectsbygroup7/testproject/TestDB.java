package dk.projectsbygroup7.testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {

        String dbConString;
        Connection conn = null;


        dbConString = "jdbc:mysql://127.0.0.2:33060/test_exam?user=projectuser&password='boB4.321'";
        conn = null;
        System.out.println(dbConString);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbConString);
            System.out.println("Connection!!");
            System.out.println(dbConString);
            System.out.println("Connection!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        dbConString = "jdbc:mysql://127.0.0.2:3306/test_exam?user=projectuser&password=boB4.321";
        conn = null;
        System.out.println(dbConString);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbConString);
            System.out.println("Connection!!");
            System.out.println(dbConString);
            System.out.println("Connection!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        dbConString = "jdbc:mysql://127.0.0.1:33060/test_exam?user=projectuser&password=boB4.321";
        conn = null;
        System.out.println(dbConString);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbConString);
            System.out.println("Connection!!");
            System.out.println(dbConString);
            System.out.println("Connection!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        dbConString = "jdbc:mysql://127.0.0.1:33061/test_exam?user=projectuser&password=boB4.321";
        conn = null;
        System.out.println(dbConString);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbConString);
            System.out.println("Connection!!");
            System.out.println(dbConString);
            System.out.println("Connection!!");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
