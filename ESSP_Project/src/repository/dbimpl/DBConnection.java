package repository.dbimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // The "hrms.db" file should be in our main project folder
    private static final String URL = "jdbc:sqlite:hrms.db";

    public static Connection getConnection() throws SQLException {
        try {
            // This loads the SQLite driver from the JAR file we added
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found. Check your lib folder!");
        }
    }
}
