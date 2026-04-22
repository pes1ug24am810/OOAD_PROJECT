package ui;

import javax.swing.*;
import service.impl.LeaveServiceImpl;

public class LeaveApplyFrame extends JFrame {
    private int employeeId;
    private LeaveServiceImpl leaveService; // Your new service layer!
    
    private JTextField startDateField;
    private JTextField endDateField;
    private JComboBox<String> leaveTypeDropdown; // Upgraded to a dropdown
    private JTextArea reasonArea;

    // Constructor now only needs the employeeId
    public LeaveApplyFrame(int employeeId) {
        this.employeeId = employeeId;
        this.leaveService = new LeaveServiceImpl(); 
        
        setTitle("Apply Leave");
        setSize(450, 420);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Leave Application");
        title.setBounds(140, 20, 200, 30);
        add(title);

        JLabel typeLabel = new JLabel("Leave Type:");
        typeLabel.setBounds(50, 70, 100, 25);
        add(typeLabel);

        // Created the Dropdown options
        String[] leaveTypes = {"Sick Leave", "Casual Leave", "Earned Leave", "Maternity/Paternity Leave"};
        leaveTypeDropdown = new JComboBox<>(leaveTypes);
        leaveTypeDropdown.setBounds(150, 70, 180, 25);
        add(leaveTypeDropdown);

        JLabel fromLabel = new JLabel("Start Date:");
        fromLabel.setBounds(50, 110, 100, 25);
        add(fromLabel);

        startDateField = new JTextField();
        startDateField.setBounds(150, 110, 180, 25);
        add(startDateField);

        JLabel toLabel = new JLabel("End Date:");
        toLabel.setBounds(50, 150, 100, 25);
        add(toLabel);

        endDateField = new JTextField();
        endDateField.setBounds(150, 150, 180, 25);
        add(endDateField);

        JLabel reasonLabel = new JLabel("Reason:");
        reasonLabel.setBounds(50, 190, 100, 25);
        add(reasonLabel);

        reasonArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(reasonArea);
        scroll.setBounds(150, 190, 180, 60);
        add(scroll);

        JButton submitButton = new JButton("Apply Leave");
        submitButton.setBounds(140, 280, 150, 30);
        add(submitButton);

        // Your updated Action Listener!
        submitButton.addActionListener(e -> {
            try {
                // Grab the data the user typed/selected
                String type = leaveTypeDropdown.getSelectedItem().toString();
                String start = startDateField.getText().trim();
                String end = endDateField.getText().trim();
                
                // (Optional: You can append the reason to the type string or handle it in your service if needed)
                String reason = reasonArea.getText().trim(); 

                if (start.isEmpty() || end.isEmpty()) {
                    throw new Exception("Start Date and End Date are required.");
                }

                // Call your newly updated service! 
                boolean success = leaveService.applyForLeave(this.employeeId, type, start, end);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Leave Applied Successfully!");
                    this.dispose(); // Close the leave window
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to apply for leave.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}