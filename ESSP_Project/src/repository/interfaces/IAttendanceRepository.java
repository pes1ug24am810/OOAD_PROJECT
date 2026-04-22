package repository.interfaces;

import model.Attendance;
import java.util.List;

public interface IAttendanceRepository {

    Attendance getAttendanceByDate(int employeeId, String date);

    List<Attendance> getMonthlyAttendance(int employeeId, String month);

    double getTotalWorkingHours(int employeeId, String month);
}