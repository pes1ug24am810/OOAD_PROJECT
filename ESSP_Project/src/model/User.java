package model;

public class User {

    public static final String ACTIVE = "ACTIVE";
    public static final String LOCKED = "LOCKED";

    private String username;
    private String password;
    private int employeeId;
    private String accountStatus;

    public User() {}

    public User(String username, String password, int employeeId, String accountStatus) {
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
        this.accountStatus = accountStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", employeeId=" + employeeId +
                ", status='" + accountStatus + '\'' +
                '}';
    }
}