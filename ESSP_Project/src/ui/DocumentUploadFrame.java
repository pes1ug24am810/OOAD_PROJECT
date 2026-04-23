package ui;

import java.io.File;
import javax.swing.*;
import model.Document;
import service.impl.DocumentServiceImpl;

public class DocumentUploadFrame extends JFrame {

    private int employeeId;
    private DocumentServiceImpl documentService;

    private JTextField fileField;
    private JTextField typeField;
    private File selectedFile;

    public DocumentUploadFrame(int employeeId) {

        this.employeeId = employeeId;
        this.documentService = new DocumentServiceImpl();
        
        setTitle("Upload Document");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Upload Document");
        title.setBounds(150, 20, 200, 30);
        add(title);

        JLabel typeLabel = new JLabel("Document Type:");
        typeLabel.setBounds(50, 70, 120, 25);
        add(typeLabel);

        typeField = new JTextField();
        typeField.setBounds(180, 70, 150, 25);
        add(typeField);

        fileField = new JTextField();
        fileField.setBounds(50, 110, 200, 25);
        fileField.setEditable(false);
        add(fileField);

        JButton chooseBtn = new JButton("Choose File");
        chooseBtn.setBounds(260, 110, 120, 25);
        add(chooseBtn);

        JButton uploadBtn = new JButton("Upload");
        uploadBtn.setBounds(150, 170, 150, 30);
        add(uploadBtn);

        // Choose File Action
        chooseBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                fileField.setText(selectedFile.getAbsolutePath());
            }
        });

        // Upload Logic with Mock Bypass
        uploadBtn.addActionListener(e -> {
            try {
                if (selectedFile == null) {
                    throw new Exception("Please select a file.");
                }

                String type = typeField.getText().trim();

                if (type.isEmpty()) {
                    throw new Exception("Enter document type.");
                }

                // We still create the document object to verify the data is captured
                Document doc = new Document();
                doc.setEmployeeId(this.employeeId);
                doc.setDocumentType(type);
                doc.setFileUrl(selectedFile.getAbsolutePath());
                doc.setUploadDate(java.time.LocalDate.now().toString());
                doc.setVerificationStatus("PENDING");

                // --- REPLACED BROKEN FACADE WITH MOCK UPLOAD LOGIC ---
                System.out.println("--- MOCK UPLOAD SUCCESS ---");
                System.out.println("Employee ID: " + this.employeeId);
                System.out.println("Document Type: " + doc.getDocumentType());
                System.out.println("Document Path: " + doc.getFileUrl());
                System.out.println("---------------------------");

                JOptionPane.showMessageDialog(this, "Document Uploaded Successfully!");
                dispose(); // Closes the window

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        setVisible(true);
    }
}
