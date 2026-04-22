package model;

public class Payroll {

    private int payrollId;
    private int employeeId;
    private double basicSalary;
    private double allowances;
    private double taxDeductions;
    private double netPay;
    private String payslipMonth;
    private String payslipFileUrl;

    public Payroll() {}

    public Payroll(int payrollId, int employeeId, double basicSalary,
                   double allowances, double taxDeductions,
                   double netPay, String payslipMonth,
                   String payslipFileUrl) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.taxDeductions = taxDeductions;
        this.netPay = netPay;
        this.payslipMonth = payslipMonth;
        this.payslipFileUrl = payslipFileUrl;
    }

    public int getPayrollId() { return payrollId; }
    public void setPayrollId(int payrollId) { this.payrollId = payrollId; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getAllowances() { return allowances; }
    public void setAllowances(double allowances) { this.allowances = allowances; }

    public double getTaxDeductions() { return taxDeductions; }
    public void setTaxDeductions(double taxDeductions) { this.taxDeductions = taxDeductions; }

    public double getNetPay() { return netPay; }
    public void setNetPay(double netPay) { this.netPay = netPay; }

    public String getPayslipMonth() { return payslipMonth; }
    public void setPayslipMonth(String payslipMonth) { this.payslipMonth = payslipMonth; }

    public String getPayslipFileUrl() { return payslipFileUrl; }
    public void setPayslipFileUrl(String payslipFileUrl) { this.payslipFileUrl = payslipFileUrl; }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollId=" + payrollId +
                ", employeeId=" + employeeId +
                ", basicSalary=" + basicSalary +
                ", allowances=" + allowances +
                ", taxDeductions=" + taxDeductions +
                ", netPay=" + netPay +
                ", month='" + payslipMonth + '\'' +
                '}';
    }
}