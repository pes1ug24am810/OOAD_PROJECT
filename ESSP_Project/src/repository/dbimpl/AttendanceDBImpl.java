package repository.dbimpl;

import repository.interfaces.IAttendanceRepository;
import model.Attendance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDBImpl implements IAttendanceRepository {

    @Override
    public Attendance getAttendanceByDate(int employeeId, String date) {
        // Changed employee_id to emp_id
        String sql = "SELECT * FROM attendance WHERE emp_id = ? AND attendance_date = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, date);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToAttendance(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Attendance> getMonthlyAttendance(int employeeId, String month) {
        List<Attendance> list = new ArrayList<>();
        // Changed employee_id to emp_id
        String sql = "SELECT * FROM attendance WHERE emp_id = ? AND attendance_date LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, month + "%"); 
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(mapResultSetToAttendance(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public double getTotalWorkingHours(int employeeId, String month) {
        // Changed working_hours to hours_worked as per db schema
        String sql = "SELECT SUM(hours_worked) as total FROM attendance WHERE emp_id = ? AND attendance_date LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, month + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private Attendance mapResultSetToAttendance(ResultSet rs) throws SQLException {
        return new Attendance(
            rs.getInt("attendance_id"), // Verify if this is record_id in our viewer
            rs.getInt("emp_id"),        // Matches db column
            rs.getString("check_in"),
            rs.getString("check_out"),
            rs.getDouble("hours_worked"), // Changed from working_hours
            rs.getString("attendance_date"),
            rs.getString("status")
        );
    }
}
