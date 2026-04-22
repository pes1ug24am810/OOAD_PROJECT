package service.interfaces;

import exception.InvalidCredentialsException;
import exception.UnauthorizedAccessException;

public interface IAuthService {
    boolean login(String username, String password) throws InvalidCredentialsException, UnauthorizedAccessException;
    
    // ADD THIS LINE
    int getEmployeeId(String username); 

    boolean changePassword(int employeeld, String newPassword);
    void logout();
}