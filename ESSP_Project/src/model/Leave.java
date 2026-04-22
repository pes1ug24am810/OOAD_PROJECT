package model;

public class Leave {

    public static final String PENDING = "PENDING";
    public static final String APPROVED = "APPROVED";
    public static final String REJECTED = "REJECTED";

    private int leaveId;
    private int employeeId;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String reason;
    private String approvalStatus;
    private int leaveBalance;

    public Leave() {}

    public Leave(int leaveId, int employeeId, String leaveType,
                 String startDate, String endDate,
                 String reason, String approvalStatus,
                 int leaveBalance) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.approvalStatus = approvalStatus;
        this.leaveBalance = leaveBalance;
    }

    public int getLeaveId() { return leaveId; }
    public void setLeaveId(int leaveId) { this.leaveId = leaveId; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getApprovalStatus() { return approvalStatus; }
    public void setApprovalStatus(String approvalStatus) { this.approvalStatus = approvalStatus; }

    public int getLeaveBalance() { return leaveBalance; }
    public void setLeaveBalance(int leaveBalance) { this.leaveBalance = leaveBalance; }

    @Override
    public String toString() {
        return "Leave{" +
                "leaveId=" + leaveId +
                ", employeeId=" + employeeId +
                ", type='" + leaveType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + approvalStatus + '\'' +
                ", balance=" + leaveBalance +
                '}';
    }
}