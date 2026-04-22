package model.enums;

public enum DocumentType {

    ID_PROOF,
    CERTIFICATE,
    EXPERIENCE_LETTER,
    OTHER;

    public static DocumentType fromString(String value) {
        try {
            return DocumentType.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return OTHER;
        }
    }
}