package repository.interfaces; // Fixed package

import dto.LeaveRequestDTO;      // Added missing import
import java.util.List;           // Added missing import

public interface ILeaveRepository {
    boolean applyLeave(LeaveRequestDTO leaveRequest);
    LeaveRequestDTO getLeaveById(String leaveId);
    List<LeaveRequestDTO> getLeavesByEmployee(String employeeId);
    boolean updateLeaveStatus(String leaveId, String status, String comments);
    boolean checkLeaveOverlap(String empId, String startDate, String endDate);
    boolean cancelLeave(String leaveId);
}