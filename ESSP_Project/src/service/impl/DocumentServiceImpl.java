package service.impl;

import java.util.List;

// Import the document model and enum
import com.hrms.db.repositories.employee_self_service.model.Document;
import com.hrms.db.repositories.employee_self_service.model.DocumentType;

// Import the repository interface and implementation
import com.hrms.db.repositories.employee_self_service.repository.interfaces.IDocumentRepository;
import com.hrms.db.repositories.employee_self_service.repository.impl.DocumentRepositoryImpl;

public class DocumentServiceImpl {

    private final IDocumentRepository documentRepository;

    public DocumentServiceImpl() {
        this.documentRepository = new DocumentRepositoryImpl();
    }

    // 1. Upload a new document
    public boolean uploadEmployeeDocument(int employeeId, DocumentType type, String fileUrl) {
        Document newDoc = new Document();
        newDoc.setEmployeeId(employeeId);
        newDoc.setDocumentType(type);
        newDoc.setFileUrl(fileUrl);
        newDoc.setVerificationStatus("PENDING");
        
        // Let the JAR handle the date automatically
        newDoc.setUploadDate(""); 

        return documentRepository.uploadDocument(newDoc);
    }

    // 2. Fetch all documents for an employee
    public List<Document> getEmployeeDocuments(int employeeId) {
        return documentRepository.getDocumentsByEmployee(employeeId);
    }

    // 3. Delete a document
    public boolean deleteDocument(int documentId) {
        return documentRepository.deleteDocument(documentId);
    }

    // 4. HR Admin updates status (e.g., APPROVED or REJECTED)
    public boolean updateStatus(int documentId, String status) {
        return documentRepository.updateDocumentStatus(documentId, status);
    }
}