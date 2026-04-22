package exception;

public class AttendanceNotFoundException extends Exception {

    public AttendanceNotFoundException() {
        super("Attendance record not found.");
    }

    public AttendanceNotFoundException(String message) {
        super(message);
    }
}