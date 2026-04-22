package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.ESSPFacade;
import model.Attendance;

public class AttendanceFrame extends JFrame {

    private ESSPFacade facade;
    private JTextArea area;
    private JTextField empIdField;
    private JTextField monthField;

    public AttendanceFrame() {

        facade = new ESSPFacade();

        setTitle("Attendance Details");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Monthly Attendance");
        title.setBounds(170, 10, 200, 30);
        add(title);

        JLabel empLabel = new JLabel("Employee ID:");
        empLabel.setBounds(50, 50, 100, 25);
        add(empLabel);

        empIdField = new JTextField();
        empIdField.setBounds(150, 50, 150, 25);
        add(empIdField);

        JLabel monthLabel = new JLabel("Month (YYYY-MM):");
        monthLabel.setBounds(50, 90, 150, 25);
        add(monthLabel);

        monthField = new JTextField();
        monthField.setBounds(200, 90, 120, 25);
        add(monthField);

        JButton loadBtn = new JButton("Load Attendance");
        loadBtn.setBounds(150, 130, 180, 30);
        add(loadBtn);

        area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(50, 180, 380, 150);
        add(scroll);

        // 🔥 Button Action
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int empId = Integer.parseInt(empIdField.getText());
                    String month = monthField.getText();

                    List<Attendance> list =
                            facade.attendance(empId, month);

                    StringBuilder sb = new StringBuilder();

                    for (Attendance a : list) {
                        sb.append(a.getAttendanceDate())
                          .append(" : ")
                          .append(a.getStatus())
                          .append(" (")
                          .append(a.getWorkingHours())
                          .append(" hrs)\n");
                    }

                    area.setText(sb.toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        setVisible(true);
    }
}