package utils;

public class ValidationUtil {

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null &&
               email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null &&
               phone.matches("\\d{10}");
    }

    public static boolean isStrongPassword(String pass) {
        return pass != null &&
               pass.length() >= 6;
    }
}