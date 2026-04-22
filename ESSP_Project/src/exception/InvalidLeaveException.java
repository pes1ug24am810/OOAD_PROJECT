package exception;

public class InvalidLeaveException extends Exception {

    public InvalidLeaveException() {
        super("Invalid leave request.");
    }

    public InvalidLeaveException(String message) {
        super(message);
    }
}