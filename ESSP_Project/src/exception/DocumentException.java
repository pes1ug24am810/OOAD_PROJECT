package exception;

public class DocumentException extends Exception {

    public DocumentException() {
        super("Document upload failed due to file error.");
    }

    public DocumentException(String message) {
        super(message);
    }
}