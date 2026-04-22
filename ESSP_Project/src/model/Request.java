package model;

/**
 * Model representing an employee request, mapped to the 'onboarding_tasks' 
 * table in hrms.db.
 */
public class Request {

    public static final String PENDING = "PENDING";
    public static final String APPROVED = "APPROVED";
    public static final String REJECTED = "REJECTED";

    // Database identifies these as UUID strings 
    private String taskId; 
    private int requestId; // Internal ID for UI indexing
    private int employeeId;
    private String requestType; // Maps to task_type 
    private String description; // Maps to task_name 
    private String status;      // Maps to status 
    private String requestDate; // Maps to due_date 
    private String createdOn;

    public Request() {}

    public Request(int requestId, int employeeId, String requestType,
                   String description, String status, String createdOn) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.requestType = requestType;
        this.description = description;
        this.status = status;
        this.createdOn = createdOn;
    }

    // New getter/setter for the database-specific UUID 
    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public String getRequestDate() { return requestDate; }
    public void setRequestDate(String requestDate) { this.requestDate = requestDate; }

    public int getRequestId() { return requestId; }
    public void setRequestId(int requestId) { this.requestId = requestId; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedOn() { return createdOn; }
    public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

    @Override
    public String toString() {
        return "Request{" +
                "taskId='" + taskId + '\'' +
                ", emp_id=" + employeeId +
                ", type='" + requestType + '\'' +
                ", status='" + status + '\'' +
                ", date='" + requestDate + '\'' +
                '}';
    }
}