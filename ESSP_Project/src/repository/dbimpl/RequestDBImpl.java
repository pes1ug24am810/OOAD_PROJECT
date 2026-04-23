package repository.dbimpl;

import repository.interfaces.IRequestRepository;
import model.Request;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDBImpl implements IRequestRepository {

    @Override
    public boolean createRequest(Request request) {
        // Table: onboarding_tasks | Columns: emp_id, task_type, task_name (description), status, due_date
        String sql = "INSERT INTO onboarding_tasks (task_id, emp_id, task_type, task_name, status, due_date) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // hrms.db uses varchar(36) for task_id, usually a UUID
            pstmt.setString(1, java.util.UUID.randomUUID().toString());
            pstmt.setInt(2, request.getEmployeeId());
            pstmt.setString(3, request.getRequestType());
            pstmt.setString(4, request.getDescription());
            pstmt.setString(5, "PENDING"); 
            pstmt.setString(6, request.getRequestDate());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Request getRequestById(int requestId) {
        // hrms.db uses varchar(36) for task_id, change query to match your ID type
        String sql = "SELECT * FROM onboarding_tasks WHERE task_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, String.valueOf(requestId));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToRequest(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Request> getRequestsByEmployee(int employeeId) {
        List<Request> list = new ArrayList<>();
        // Changed employee_id to emp_id as per db schema
        String sql = "SELECT * FROM onboarding_tasks WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(mapResultSetToRequest(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateRequestStatus(int requestId, String status) {
        String sql = "UPDATE onboarding_tasks SET status = ? WHERE task_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, status);
            pstmt.setString(2, String.valueOf(requestId));
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRequest(int requestId) {
        String sql = "DELETE FROM onboarding_tasks WHERE task_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, String.valueOf(requestId));
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Request mapResultSetToRequest(ResultSet rs) throws SQLException {
        Request r = new Request();
        r.setRequestId(rs.getRow()); // Placeholder if our UI expects an int
        r.setEmployeeId(rs.getInt("emp_id"));       // Matches emp_id column
        r.setRequestType(rs.getString("task_type")); // Matches task_type column
        r.setDescription(rs.getString("task_name")); // Matches task_name column
        r.setStatus(rs.getString("status"));        // Matches status column
        r.setRequestDate(rs.getString("due_date"));  // Matches due_date column
        return r;
    }
}
