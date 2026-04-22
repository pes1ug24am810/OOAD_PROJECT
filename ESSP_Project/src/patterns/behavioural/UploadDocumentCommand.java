package patterns.behavioural;

import controller.ESSPFacade;
import model.Document;
import exception.DocumentException;
import exception.InvalidFileFormatException;
import javax.swing.JOptionPane;

public class UploadDocumentCommand implements Command {

    private ESSPFacade facade;
    private Document document;

    public UploadDocumentCommand(ESSPFacade facade, Document document) {
        this.facade = facade;
        this.document = document;
    }

    @Override
    public void execute() {
        try {
            // Wrapping the call to handle the checked exceptions
            boolean success = facade.uploadDocument(document);
            
            if (success) {
                JOptionPane.showMessageDialog(null, "Document uploaded successfully!");
            }
        } catch (DocumentException | InvalidFileFormatException e) {
            // Specific handling for document-related errors
            JOptionPane.showMessageDialog(null, "Upload Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // General catch-all for any other runtime issues
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
        }
    }
}