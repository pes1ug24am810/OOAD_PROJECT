package repository.dbimpl;

import repository.interfaces.IEmployeeRepository;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBImpl implements IEmployeeRepository {

    @Override
    public Employee getEmployeeById(int employeeId) {
        // Updated column name to emp_id
        String sql = "SELECT * FROM employees WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToEmployee(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveEmployee(Employee emp) {
        // Updated column names: emp_id, date_of_joining, employment_status
        String sql = "INSERT INTO employees (emp_id, name, email, phone, address, department, designation, date_of_joining, employment_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, emp.getEmployeeId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhone());
            pstmt.setString(5, emp.getAddress());
            pstmt.setString(6, emp.getDepartment());
            pstmt.setString(7, emp.getDesignation());
            pstmt.setString(8, emp.getDateOfJoining());
            pstmt.setString(9, emp.getAccountStatus());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        // Updated WHERE clause to emp_id and status to employment_status
        String sql = "UPDATE employees SET name=?, email=?, phone=?, address=?, department=?, designation=?, employment_status=? WHERE emp_id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getEmail());
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getAddress());
            pstmt.setString(5, emp.getDepartment());
            pstmt.setString(6, emp.getDesignation());
            pstmt.setString(7, emp.getAccountStatus());
            pstmt.setInt(8, emp.getEmployeeId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployeeContact(int employeeId, String phone, String email) {
        String sql = "UPDATE employees SET phone = ?, email = ? WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, phone);
            pstmt.setString(2, email);
            pstmt.setInt(3, employeeId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        // Adjusted column labels to match hrms.db schema
        return new Employee(
            rs.getInt("emp_id"),            // Changed from employee_id 
            rs.getString("name"),          
            rs.getString("email"),         
            rs.getString("phone"),         
            rs.getString("address"),       
            rs.getString("department"),    
            rs.getString("designation"),   
            rs.getString("date_of_joining"),// Changed from doj 
            rs.getString("employment_status") // Changed from status 
        );
    }
}
