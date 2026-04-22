package service.interfaces;

import model.Leave;
import java.util.List;

import exception.InvalidLeaveException;
import exception.LeaveBalanceException;
import exception.InvalidDateRangeException;

public interface ILeaveService {

    boolean applyLeave(Leave leave)
            throws InvalidLeaveException,
                   LeaveBalanceException,
                   InvalidDateRangeException;

    List<Leave> viewLeaveHistory(int employeeId)
            throws InvalidLeaveException;

    int checkLeaveBalance(int employeeId);

    boolean cancelLeave(int leaveId)
            throws InvalidLeaveException;
}