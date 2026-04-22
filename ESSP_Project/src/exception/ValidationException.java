package exception;

public class ValidationException extends Exception {

    public ValidationException() {
        super("Validation error occurred.");
    }

    public ValidationException(String message) {
        super(message);
    }
}