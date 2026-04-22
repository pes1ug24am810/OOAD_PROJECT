package exception;

public class PayrollUnavailableException extends Exception {

    public PayrollUnavailableException() {
        super("Payroll data not available.");
    }

    public PayrollUnavailableException(String message) {
        super(message);
    }
}