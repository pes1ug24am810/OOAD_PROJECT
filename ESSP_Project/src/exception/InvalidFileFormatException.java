package exception;

public class InvalidFileFormatException extends Exception {

    public InvalidFileFormatException() {
        super("Unsupported file format.");
    }

    public InvalidFileFormatException(String message) {
        super(message);
    }
}