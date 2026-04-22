package patterns.creational;

// This import is now used because we reference the interfaces below
import repository.interfaces.*;
import repository.dbimpl.*;

public class RepositoryFactory {

    public static Object getRepository(String type) {
        if (type == null) return null;

        switch (type.toUpperCase()) {
            case "AUTH":
                // Cast to interface to justify the import
                return (IAuthRepository) new AuthDBImpl();

            case "EMPLOYEE":
                return (IEmployeeRepository) new EmployeeDBImpl();

            case "LEAVE":
                return (ILeaveRepository) new LeaveDBImpl();

            case "DOCUMENT":
                return (IDocumentRepository) new DocumentDBImpl();

            case "REQUEST":
                return (IRequestRepository) new RequestDBImpl();

            case "PAYROLL":
                return (IPayrollRepository) new PayrollDBImpl();

            case "ATTENDANCE":
                return (IAttendanceRepository) new AttendanceDBImpl();

            default:
                return null;
        }
    }
}