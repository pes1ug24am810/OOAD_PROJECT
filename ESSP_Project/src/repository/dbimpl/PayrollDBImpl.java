package repository.dbimpl;

import repository.interfaces.IPayrollRepository;
import model.Payroll;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDBImpl implements IPayrollRepository {

    @Override
    public Payroll getPayrollByEmployeeAndMonth(int employeeId, String month) {
        // Table name: payroll_results | columns: emp_id, pay_period
        String sql = "SELECT * FROM payroll_results WHERE emp_id = ? AND pay_period = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, month);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToPayroll(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Payroll> getPayrollHistory(int employeeId) {
        List<Payroll> list = new ArrayList<>();
        // Table name: payroll_results | column: emp_id
        String sql = "SELECT * FROM payroll_results WHERE emp_id = ? ORDER BY processed_at DESC";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(mapResultSetToPayroll(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Payroll mapResultSetToPayroll(ResultSet rs) throws SQLException {
        // Mapping according to payroll_results schema in hrms.db
        return new Payroll(
            rs.getInt("record_id"),       // Database uses record_id as PK 
            rs.getInt("emp_id"),          // Database uses emp_id 
            rs.getDouble("final_gross_pay"), // Closest match for basic 
            rs.getDouble("overtime_pay"),   // Matches allowances 
            rs.getDouble("monthly_tds_amount"), // Matches tax_deductions 
            rs.getDouble("final_net_pay"),  // Matches net_salary 
            rs.getString("pay_period"),    // Database uses pay_period 
            "URL_NOT_IN_TABLE"             // file_url is in file_references table, not here
        );
    }
}