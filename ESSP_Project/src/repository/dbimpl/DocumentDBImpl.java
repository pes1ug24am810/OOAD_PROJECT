package repository.dbimpl;

import repository.interfaces.IDocumentRepository;
import model.Document;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDBImpl implements IDocumentRepository {

    @Override
    public boolean uploadDocument(Document doc) {
        // Changed employee_id to emp_id and file_url to file_path
        String sql = "INSERT INTO documents (emp_id, document_type, file_path, upload_date, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, doc.getEmployeeId());
            pstmt.setString(2, doc.getDocumentType());
            pstmt.setString(3, doc.getFileUrl());
            pstmt.setString(4, doc.getUploadDate());
            pstmt.setString(5, doc.getVerificationStatus());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Document getDocumentById(int documentId) {
        String sql = "SELECT * FROM documents WHERE document_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, documentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToDocument(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Document> getDocumentsByEmployee(int employeeId) {
        List<Document> list = new ArrayList<>();
        // Changed employee_id to emp_id
        String sql = "SELECT * FROM documents WHERE emp_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(mapResultSetToDocument(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteDocument(int documentId) {
        String sql = "DELETE FROM documents WHERE document_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, documentId);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateDocumentStatus(int documentId, String status) {
        String sql = "UPDATE documents SET status = ? WHERE document_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, status);
            pstmt.setInt(2, documentId);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Document mapResultSetToDocument(ResultSet rs) throws SQLException {
        Document doc = new Document();
        doc.setDocumentId(rs.getInt("document_id"));
        doc.setEmployeeId(rs.getInt("emp_id"));       // Changed from employee_id
        doc.setDocumentType(rs.getString("document_type"));
        doc.setFileUrl(rs.getString("file_path"));    // Changed from file_url
        doc.setUploadDate(rs.getString("upload_date"));
        doc.setVerificationStatus(rs.getString("status"));
        return doc;
    }
}