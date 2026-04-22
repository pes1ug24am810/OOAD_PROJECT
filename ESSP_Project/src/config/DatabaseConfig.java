package config;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    private DatabaseConfig() {}

    public static final String DRIVER =
            "com.mysql.cj.jdbc.Driver";

    public static final String URL =
            "jdbc:mysql://localhost:3306/essp_db";

    public static final String USERNAME = "root";

    public static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("DB Connection Failed", e);
        }
    }
}