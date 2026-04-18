import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/auto_company_db_v2", "root", "password"); //insert your password here
            System.out.print("Connection to database established successfully.");
            return conn;
        } catch (SQLException e) {
            System.out.print("Error connecting to database: " + e.getMessage());
            return null;
        }
    }
}