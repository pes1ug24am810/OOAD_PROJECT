package exception;

public class DatabaseConnectionException extends Exception {

    public DatabaseConnectionException() {
        super("Unable to connect to database.");
    }

    public DatabaseConnectionException(String message) {
        super(message);
    }
}