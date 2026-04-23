package repository.dbimpl;

import repository.interfaces.ILeaveRepository;
import model.Leave;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveDBImpl implements ILeaveRepository {

    @Override
    public boolean applyLeave(Leave leave) {
        // Table renamed to leave_records; employee_id changed to emp_id
        String sql = "INSERT INTO leave_records (emp_id, leave_type, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, leave.getEmployeeId());
            pstmt.setString(2, leave.getLeaveType());
            pstmt.setString(3, leave.getStartDate());
            pstmt.setString(4, leave.getEndDate());
            pstmt.setString(5, "PENDING"); 
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Leave getLeaveById(int leaveId) {
        String sql = "SELECT * FROM leave_records WHERE leave_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, leaveId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToLeave(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Leave> getLeavesByEmployee(int employeeId) {
        List<Leave> list = new ArrayList<>();
        String sql = "SELECT * FROM leave_records WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(mapResultSetToLeave(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateLeaveStatus(int leaveId, String status) {
        String sql = "UPDATE leave_records SET status = ? WHERE leave_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, status);
            pstmt.setInt(2, leaveId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getLeaveBalance(int employeeId) {
        // Querying the specific leave_balances table from hrms.db
        String sql = "SELECT balance FROM leave_balances WHERE emp_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("balance"); // balance column confirmed in schema
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }

    @Override
    public boolean cancelLeave(int leaveId) {
        String sql = "UPDATE leave_records SET status = 'CANCELLED' WHERE leave_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, leaveId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Leave mapResultSetToLeave(ResultSet rs) throws SQLException {
        Leave l = new Leave();
        l.setLeaveId(rs.getInt("leave_id"));
        l.setEmployeeId(rs.getInt("emp_id")); // Mapping emp_id to our model
        l.setLeaveType(rs.getString("leave_type"));
        l.setStartDate(rs.getString("start_date"));
        l.setEndDate(rs.getString("end_date"));
        l.setApprovalStatus(rs.getString("status"));
        return l;
    }
}
