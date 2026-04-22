package model;

public class Employee {

    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_INACTIVE = "INACTIVE";
    public static final String STATUS_LOCKED = "LOCKED";

    private int employeeId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String designation;
    private String dateOfJoining;
    private String accountStatus;

    public Employee() {}

    public Employee(int employeeId, String name, String email, String phone,
                    String address, String department, String designation,
                    String dateOfJoining, String accountStatus) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.accountStatus = accountStatus;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(String dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String accountStatus) { this.accountStatus = accountStatus; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", status='" + accountStatus + '\'' +
                '}';
    }
}