package exception;

public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException() {
        super("Incorrect username or password.");
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }
}