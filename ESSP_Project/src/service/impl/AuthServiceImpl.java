package service.impl;

// Import the interfaces and implementations from the JAR
import com.hrms.db.repositories.employee_self_service.repository.interfaces.IAuthRepository;
import com.hrms.db.repositories.employee_self_service.repository.impl.AuthRepositoryImpl;

public class AuthServiceImpl {

    private final IAuthRepository authRepository;

    public AuthServiceImpl() {
        // This automatically initializes the DB and creates tables if they don't exist!
        this.authRepository = new AuthRepositoryImpl();
    }

    // 1. Authenticate user
    public boolean login(String username, String password) {
        return authRepository.validateUser(username, password);
    }

    // 2. Get Employee ID after login
    public int getEmployeeIdByUsername(String username) {
        return authRepository.getEmployeeId(username);
    }

    // 3. Change password
    public boolean changePassword(int employeeId, String newPassword) {
        return authRepository.updatePassword(employeeId, newPassword);
    }

    // 4. Check if account is locked
    public boolean isAccountLocked(String username) {
        return authRepository.isAccountLocked(username);
    }
}