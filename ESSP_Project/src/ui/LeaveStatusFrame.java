package ui;

import javax.swing.*;
import java.util.List;

import controller.ESSPFacade;
import model.Leave;

public class LeaveStatusFrame extends JFrame {

    private int employeeId;
    private ESSPFacade facade;
    private JTextArea area;

    public LeaveStatusFrame(int employeeId, ESSPFacade facade) {

        this.employeeId = employeeId;
        this.facade = facade;

        setTitle("Leave Status");
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Leave History");
        title.setBounds(150, 20, 150, 30);
        add(title);

        area = new JTextArea();
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(50, 70, 330, 200);
        add(scroll);

        loadLeaveHistory();

        setVisible(true);
    }

    private void loadLeaveHistory() {

        try {
            List<Leave> list = facade.leaveHistory(employeeId);

            StringBuilder sb = new StringBuilder();

            for (Leave l : list) {
                sb.append(l.getStartDate())
                  .append(" to ")
                  .append(l.getEndDate())
                  .append(" : ")
                  .append(l.getApprovalStatus())
                  .append("\n");
            }

            area.setText(sb.toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}