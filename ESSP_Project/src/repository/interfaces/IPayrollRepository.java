package repository.interfaces;

import model.Payroll;
import java.util.List;

public interface IPayrollRepository {

    Payroll getPayrollByEmployeeAndMonth(int employeeId, String month);

    List<Payroll> getPayrollHistory(int employeeId);
}