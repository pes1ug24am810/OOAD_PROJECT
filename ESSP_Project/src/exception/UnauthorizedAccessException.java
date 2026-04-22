package exception;

public class UnauthorizedAccessException extends Exception {

    public UnauthorizedAccessException() {
        super("You do not have permission to access this resource.");
    }

    public UnauthorizedAccessException(String message) {
        super(message);
    }
}