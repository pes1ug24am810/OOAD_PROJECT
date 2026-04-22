package model.enums;

public enum LeaveStatus {

    PENDING,
    APPROVED,
    REJECTED;

    public static LeaveStatus fromString(String value) {
        try {
            return LeaveStatus.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return PENDING;
        }
    }
}