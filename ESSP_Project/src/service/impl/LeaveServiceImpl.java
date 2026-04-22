package service.impl;

// Updated to point to the correct 'interfaces' folder
import dto.LeaveRequestDTO;
import repository.interfaces.ILeaveRepository;
import repository.interfaces.MockLeaveRepositoryImpl;             

public class LeaveServiceImpl {
    private ILeaveRepository leaveRepository;

    public LeaveServiceImpl() {
        this.leaveRepository = new MockLeaveRepositoryImpl(); 
    }

    public boolean applyForLeave(int employeeId, String leaveType, String startDate, String endDate) {
        LeaveRequestDTO newLeave = new LeaveRequestDTO();
        newLeave.setEmployeeId(String.valueOf(employeeId)); 
        newLeave.setStartDate(startDate);
        newLeave.setEndDate(endDate);
        newLeave.setComments("Leave Type: " + leaveType); 
        newLeave.setStatus("PENDING");

        return leaveRepository.applyLeave(newLeave);
    }
}