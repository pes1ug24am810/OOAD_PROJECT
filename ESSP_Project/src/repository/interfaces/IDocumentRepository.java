package repository.interfaces;

import java.util.List;
import model.Document;

public interface IDocumentRepository {

    boolean uploadDocument(Document document);

    Document getDocumentById(int documentId);

    List<Document> getDocumentsByEmployee(int employeeId);

    boolean deleteDocument(int documentId);

    boolean updateDocumentStatus(int documentId, String status);
}  