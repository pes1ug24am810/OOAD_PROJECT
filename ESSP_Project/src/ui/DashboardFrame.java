package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    private int loggedInEmployeeId;

    // Constructor requires the Employee ID from the LoginFrame
    public DashboardFrame(int employeeId) {
        this.loggedInEmployeeId = employeeId;

        setTitle("Employee Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 15, 15));

        // Create Navigation Buttons
        JButton profileBtn = new JButton("My Profile");
        JButton leaveBtn = new JButton("Apply for Leave");
        JButton documentsBtn = new JButton("My Documents");
        JButton logoutBtn = new JButton("Logout");

        // Add them to the frame
        add(profileBtn);
        add(leaveBtn);
        add(documentsBtn);
        add(logoutBtn);

        // Action Listeners to open the next frames
        profileBtn.addActionListener(e -> new ProfileFrame(loggedInEmployeeId).setVisible(true));
        
        leaveBtn.addActionListener(e -> new LeaveApplyFrame(loggedInEmployeeId).setVisible(true));
        
        documentsBtn.addActionListener(e -> new DocumentUploadFrame(loggedInEmployeeId).setVisible(true));

        logoutBtn.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            this.dispose(); // Close dashboard
        });
    }
}