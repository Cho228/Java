package Lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection(String url, String name, String pass) {
        try {
            return DriverManager.getConnection(url, name, pass);
        } catch (SQLException e ) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
            e.printStackTrace();
            return null;
        }
    }
}