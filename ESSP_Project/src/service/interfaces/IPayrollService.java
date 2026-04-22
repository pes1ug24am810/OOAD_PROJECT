package service.interfaces;

import model.Payroll;
import java.util.List;

import exception.PayrollUnavailableException;

public interface IPayrollService {

    Payroll viewPayslip(int employeeId, String month)
            throws PayrollUnavailableException;

    List<Payroll> payrollHistory(int employeeId)
            throws PayrollUnavailableException;
}