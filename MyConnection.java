package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class MyConnection {
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="root";
    public static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/bkacad";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_CONNECTION_URL,DB_PASSWORD,DB_USER);
    }
}
