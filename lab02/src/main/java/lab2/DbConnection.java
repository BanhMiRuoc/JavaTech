package lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection(String url) {
        Connection connection = null;
        try {
            // Chỉ sử dụng URL để kết nối, không cần username và password
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}
