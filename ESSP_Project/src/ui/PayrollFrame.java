package ui;

import javax.swing.*;
import controller.ESSPFacade;
import model.Payroll;

public class PayrollFrame extends JFrame {
    private int employeeId;
    private ESSPFacade facade; 
    private JTextField monthField;
    private JTextArea area;

    public PayrollFrame(int employeeId, ESSPFacade facade) {
        this.employeeId = employeeId;
        this.facade = facade; 
        setTitle("Payroll Details");
        setSize(450, 380);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Employee Payslip");
        title.setBounds(140, 20, 200, 30);
        add(title);

        JLabel monthLabel = new JLabel("Month:");
        monthLabel.setBounds(60, 70, 100, 25);
        add(monthLabel);

        monthField = new JTextField();
        monthField.setBounds(120, 70, 150, 25);
        add(monthField);

        JButton loadBtn = new JButton("Load Payslip");
        loadBtn.setBounds(140, 110, 150, 30);
        add(loadBtn);

        area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(60, 160, 300, 150);
        add(scroll);

        // This lambda block is where we use the field to remove the warning
        loadBtn.addActionListener(e -> {
            try {
                String month = monthField.getText().trim();
                if (month.isEmpty()) {
                    throw new Exception("Enter month.");
                }
                
                // Explicitly use 'this.facade' 
                Payroll p = this.facade.viewPayslip(this.employeeId, month);
                
                String data = "Month: " + p.getPayslipMonth() + "\n" +
                             "Basic Salary: " + p.getBasicSalary() + "\n" +
                             "Allowances: " + p.getAllowances() + "\n" +
                             "Tax Deductions: " + p.getTaxDeductions() + "\n" +
                             "Net Pay: " + p.getNetPay();
                area.setText(data);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
