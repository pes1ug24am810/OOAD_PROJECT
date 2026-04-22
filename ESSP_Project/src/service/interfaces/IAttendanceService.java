package service.interfaces;

import model.Attendance;
import java.util.List;

import exception.AttendanceNotFoundException;

public interface IAttendanceService {

    List<Attendance> monthlyAttendance(int employeeId,
                                       String month)
            throws AttendanceNotFoundException;

    double totalWorkingHours(int employeeId,
                             String month)
            throws AttendanceNotFoundException;
}