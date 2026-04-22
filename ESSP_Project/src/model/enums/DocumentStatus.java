package model.enums;

public enum DocumentStatus {

    UPLOADED,
    VERIFIED,
    REJECTED;

    public static DocumentStatus fromString(String value) {
        try {
            return DocumentStatus.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return UPLOADED;
        }
    }
}