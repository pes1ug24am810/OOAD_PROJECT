package service.impl;

import model.Payroll;
import service.interfaces.IPayrollService;
import repository.interfaces.IPayrollRepository;

import exception.PayrollUnavailableException;

import java.util.List;

public class PayrollServiceImpl implements IPayrollService {

    private IPayrollRepository repo;

    public PayrollServiceImpl(IPayrollRepository repo) {
        this.repo = repo;
    }

    @Override
    public Payroll viewPayslip(int empId, String month)
            throws PayrollUnavailableException {

        if (empId <= 0 || month == null || month.isEmpty()) {
            throw new IllegalArgumentException("Invalid input.");
        }

        Payroll payroll =
                repo.getPayrollByEmployeeAndMonth(empId, month);

        if (payroll == null) {
            throw new PayrollUnavailableException();
        }

        return payroll;
    }

    @Override
    public List<Payroll> payrollHistory(int employeeId)
            throws PayrollUnavailableException {

        if (employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        List<Payroll> list =
                repo.getPayrollHistory(employeeId);

        if (list == null || list.isEmpty()) {
            throw new PayrollUnavailableException("No payroll history found.");
        }

        return list;
    }
}