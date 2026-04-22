package service.interfaces;

import model.Document;
import java.util.List;

import exception.DocumentException;
import exception.InvalidFileFormatException;

public interface IDocumentService {

    boolean uploadDocument(Document document)
            throws DocumentException,
                   InvalidFileFormatException;

    List<Document> viewDocuments(int employeeId)
            throws DocumentException;

    boolean deleteDocument(int documentId)
            throws DocumentException;
}