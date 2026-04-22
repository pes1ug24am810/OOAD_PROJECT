package patterns.creational;

import service.interfaces.*;
import service.impl.*;

import repository.interfaces.*;

public class ServiceFactory {

    public static IAuthService getAuthService() {
        IAuthRepository repo =
            (IAuthRepository) RepositoryFactory.getRepository("AUTH");
        return AuthServiceImpl.getInstance(repo);
    }

    public static IEmployeeService getEmployeeService() {
        IEmployeeRepository repo =
            (IEmployeeRepository) RepositoryFactory.getRepository("EMPLOYEE");
        return new EmployeeServiceImpl(repo);
    }

    public static ILeaveService getLeaveService() {
        ILeaveRepository repo =
            (ILeaveRepository) RepositoryFactory.getRepository("LEAVE");
        return new LeaveServiceImpl(repo);
    }

    public static IDocumentService getDocumentService() {
        IDocumentRepository repo =
            (IDocumentRepository) RepositoryFactory.getRepository("DOCUMENT");
        return new DocumentServiceImpl(repo);
    }

    public static IRequestService getRequestService() {
        IRequestRepository repo =
            (IRequestRepository) RepositoryFactory.getRepository("REQUEST");
        return new RequestServiceImpl(repo);
    }

    public static IPayrollService getPayrollService() {
        IPayrollRepository repo =
            (IPayrollRepository) RepositoryFactory.getRepository("PAYROLL");
        return new PayrollServiceImpl(repo);
    }

    public static IAttendanceService getAttendanceService() {
        IAttendanceRepository repo =
            (IAttendanceRepository) RepositoryFactory.getRepository("ATTENDANCE");
        return new AttendanceServiceImpl(repo);
    }
}