import service.impl.AuthServiceImpl;

public class DatabaseIntegrationTest {
    public static void main(String[] args) {
        AuthServiceImpl authService = new AuthServiceImpl();
        
        System.out.println("1. Forcing password reset using the JAR's internal encryption...");
        // Change password for Employee ID 1 (Alice)
        boolean resetSuccess = authService.changePassword(1, "password123");
        System.out.println("Password Reset: " + resetSuccess);

        System.out.println("\n2. Testing Login again...");
        boolean loginSuccess = authService.login("alice@company.com", "password123");
        System.out.println("Final Login Result: " + loginSuccess);
    }
}