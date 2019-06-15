package dk.projectsbygroup7.testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {

        String dbConString;
        Connection conn = null;


        dbConString = "jdbc:mysql://172.17.0.2/test_exam?user=projectuser&password=boB4.321";
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
