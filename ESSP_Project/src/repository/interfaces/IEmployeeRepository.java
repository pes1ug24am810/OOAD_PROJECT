package repository.interfaces;

import model.Employee;
import java.util.List;

public interface IEmployeeRepository {

    boolean saveEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    boolean updateEmployee(Employee employee);

    boolean updateEmployeeContact(int employeeId, String phone, String email);

    boolean deleteEmployee(int employeeId);
}