package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static final String driver = "com.mysql.jdbc.Driver";

    private static final String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";

    private static final String username = "root";

    private static final String password = "312";

    private static Connection connection = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = DBHelper.getConnection();
            if (connection != null) {
                System.out.println("connection is normal!");
            } else {
                System.out.println("connection is failure!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
