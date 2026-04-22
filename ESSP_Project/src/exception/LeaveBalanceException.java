package exception;

public class LeaveBalanceException extends Exception {

    public LeaveBalanceException() {
        super("Insufficient leave balance.");
    }

    public LeaveBalanceException(String message) {
        super(message);
    }
}