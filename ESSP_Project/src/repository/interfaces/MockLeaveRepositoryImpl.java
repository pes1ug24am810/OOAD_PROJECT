package repository.interfaces; // Fixed package

import dto.LeaveRequestDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockLeaveRepositoryImpl implements ILeaveRepository {
    @Override
    public boolean applyLeave(LeaveRequestDTO leaveRequest) {
        leaveRequest.setLeaveId(UUID.randomUUID().toString());
        System.out.println("--- MOCK DATABASE SUCCESS ---");
        System.out.println("Saved Leave for Employee: " + leaveRequest.getEmployeeId());
        return true; 
    }

    @Override
    public LeaveRequestDTO getLeaveById(String leaveId) { return null; }

    @Override
    public List<LeaveRequestDTO> getLeavesByEmployee(String employeeId) { return new ArrayList<>(); }

    @Override
    public boolean updateLeaveStatus(String leaveId, String status, String comments) { return true; }

    @Override
    public boolean checkLeaveOverlap(String empId, String startDate, String endDate) { return false; }

    @Override
    public boolean cancelLeave(String leaveId) { return true; }
}