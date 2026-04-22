package model;

public class Document {

    public static final String TYPE_ID_PROOF = "ID_PROOF";
    public static final String TYPE_CERTIFICATE = "CERTIFICATE";

    public static final String STATUS_UPLOADED = "UPLOADED";
    public static final String STATUS_VERIFIED = "VERIFIED";
    public static final String STATUS_REJECTED = "REJECTED";

    private int documentId;
    private int employeeId;
    private String documentType;
    private String fileUrl;
    private String uploadDate;
    private String verificationStatus;

    public Document() {}

    public Document(int documentId, int employeeId, String documentType,
                    String fileUrl, String uploadDate,
                    String verificationStatus) {
        this.documentId = documentId;
        this.employeeId = employeeId;
        this.documentType = documentType;
        this.fileUrl = fileUrl;
        this.uploadDate = uploadDate;
        this.verificationStatus = verificationStatus;
    }

    public int getDocumentId() { return documentId; }
    public void setDocumentId(int documentId) { this.documentId = documentId; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public String getUploadDate() { return uploadDate; }
    public void setUploadDate(String uploadDate) { this.uploadDate = uploadDate; }

    public String getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(String verificationStatus) { this.verificationStatus = verificationStatus; }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", employeeId=" + employeeId +
                ", type='" + documentType + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                ", status='" + verificationStatus + '\'' +
                '}';
    }
}