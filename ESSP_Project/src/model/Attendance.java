package model;

public class Attendance {

    public static final String PRESENT = "PRESENT";
    public static final String ABSENT = "ABSENT";

    private int attendanceId;
    private int employeeId;
    private String checkInTime;
    private String checkOutTime;
    private double workingHours;
    private String attendanceDate;
    private String status;

    public Attendance() {}

    public Attendance(int attendanceId, int employeeId, String checkInTime,
                      String checkOutTime, double workingHours,
                      String attendanceDate, String status) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.workingHours = workingHours;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    public int getAttendanceId() { return attendanceId; }
    public void setAttendanceId(int attendanceId) { this.attendanceId = attendanceId; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getCheckInTime() { return checkInTime; }
    public void setCheckInTime(String checkInTime) { this.checkInTime = checkInTime; }

    public String getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(String checkOutTime) { this.checkOutTime = checkOutTime; }

    public double getWorkingHours() { return workingHours; }
    public void setWorkingHours(double workingHours) { this.workingHours = workingHours; }

    public String getAttendanceDate() { return attendanceDate; }
    public void setAttendanceDate(String attendanceDate) { this.attendanceDate = attendanceDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", employeeId=" + employeeId +
                ", date='" + attendanceDate + '\'' +
                ", checkIn='" + checkInTime + '\'' +
                ", checkOut='" + checkOutTime + '\'' +
                ", hours=" + workingHours +
                ", status='" + status + '\'' +
                '}';
    }
}