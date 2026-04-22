package repository.dbimpl;

import repository.interfaces.IAuthRepository;
import java.sql.*;

public class AuthDBImpl implements IAuthRepository {

    @Override
    public boolean validateUser(String username, String password) {
        // Updated table name/columns to match common hrms.db patterns
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); 
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getEmployeeId(String username) {
        // Changed column name from employee_id to emp_id as per .db schema
        String sql = "SELECT emp_id FROM users WHERE username = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("emp_id"); // Updated column label
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }

    @Override
    public boolean updatePassword(int employeeId, String newPassword) {
        // Changed WHERE clause to use emp_id
        String sql = "UPDATE users SET password = ? WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, employeeId); // This value comes from your Java logic
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isAccountLocked(String username) {
        // Checking employment_status or account status columns
        String sql = "SELECT status FROM users WHERE username = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String status = rs.getString("status");
                return "LOCKED".equalsIgnoreCase(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}