package ui;

import javax.swing.*;
import java.util.List;

import controller.ESSPFacade;
import model.Request;

public class RequestFrame extends JFrame {

    private int employeeId;
    private ESSPFacade facade;

    private JTextField typeField;
    private JTextArea descArea;
    private JTextArea historyArea;

    public RequestFrame(int employeeId, ESSPFacade facade) {

        this.employeeId = employeeId;
        this.facade = facade;

        setTitle("General Requests");
        setSize(500, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Raise Request");
        title.setBounds(180, 20, 200, 30);
        add(title);

        JLabel typeLabel = new JLabel("Request Type:");
        typeLabel.setBounds(50, 70, 120, 25);
        add(typeLabel);

        typeField = new JTextField();
        typeField.setBounds(180, 70, 200, 25);
        add(typeField);

        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(50, 110, 120, 25);
        add(descLabel);

        descArea = new JTextArea();
        JScrollPane descScroll = new JScrollPane(descArea);
        descScroll.setBounds(180, 110, 200, 70);
        add(descScroll);

        JButton submitBtn = new JButton("Submit Request");
        submitBtn.setBounds(170, 200, 150, 30);
        add(submitBtn);

        historyArea = new JTextArea();
        historyArea.setEditable(false);

        JScrollPane historyScroll = new JScrollPane(historyArea);
        historyScroll.setBounds(50, 250, 380, 140);
        add(historyScroll);

        // 🔥 Submit Logic
        submitBtn.addActionListener(e -> submitRequest());

        loadRequests();

        setVisible(true);
    }

    private void submitRequest() {

        try {
            String type = typeField.getText();
            String desc = descArea.getText();

            if (type.isEmpty() || desc.isEmpty()) {
                throw new Exception("All fields are required.");
            }

            Request req = new Request();
            req.setEmployeeId(employeeId);
            req.setRequestType(type);
            req.setDescription(desc);
            req.setStatus("PENDING"); // DB controlled
            req.setCreatedOn("NOW");  // placeholder (DB should handle actual date)

            boolean success = facade.submitRequest(req);

            if (success) {
                JOptionPane.showMessageDialog(this, "Request Submitted");
                typeField.setText("");
                descArea.setText("");
                loadRequests();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void loadRequests() {

        try {
            List<Request> list = facade.viewRequests(employeeId);

            StringBuilder sb = new StringBuilder();

            for (Request r : list) {
                sb.append(r.getRequestType())
                  .append(" : ")
                  .append(r.getStatus())
                  .append("\n");
            }

            historyArea.setText(sb.toString());

        } catch (Exception e) {
            historyArea.setText("No requests found.");
        }
    }
}