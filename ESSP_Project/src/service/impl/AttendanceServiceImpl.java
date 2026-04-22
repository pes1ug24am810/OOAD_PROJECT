package service.impl;

import model.Attendance;
import service.interfaces.IAttendanceService;
import repository.interfaces.IAttendanceRepository;

import exception.AttendanceNotFoundException;

import java.util.List;

public class AttendanceServiceImpl implements IAttendanceService {

    private IAttendanceRepository repo;

    public AttendanceServiceImpl(IAttendanceRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Attendance> monthlyAttendance(int empId,
                                              String month)
            throws AttendanceNotFoundException {

        if (empId <= 0 || month == null || month.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<Attendance> list =
                repo.getMonthlyAttendance(empId, month);

        if (list == null || list.isEmpty()) {
            throw new AttendanceNotFoundException();
        }

        return list;
    }

    @Override
    public double totalWorkingHours(int empId,
                                    String month)
            throws AttendanceNotFoundException {

        if (empId <= 0 || month == null || month.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        double hours = repo.getTotalWorkingHours(empId, month);

        if (hours <= 0) {
            throw new AttendanceNotFoundException("Working hours not found.");
        }

        return hours;
    }
}