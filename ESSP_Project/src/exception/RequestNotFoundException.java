package exception;

public class RequestNotFoundException extends Exception {

    public RequestNotFoundException() {
        super("Requested record does not exist.");
    }

    public RequestNotFoundException(String message) {
        super(message);
    }
}