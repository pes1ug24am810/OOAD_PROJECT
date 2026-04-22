package controller;

import model.*;
import service.interfaces.*;
import patterns.creational.ServiceFactory;
import exception.*; 
import java.util.List;

public class ESSPFacade {
    private IAuthService authService;
    private IEmployeeService employeeService;
    private ILeaveService leaveService;
    private IDocumentService documentService;
    private IRequestService requestService;
    private IPayrollService payrollService;
    private IAttendanceService attendanceService;

    public ESSPFacade() {
        authService = ServiceFactory.getAuthService();
        employeeService = ServiceFactory.getEmployeeService();
        leaveService = ServiceFactory.getLeaveService();
        documentService = ServiceFactory.getDocumentService();
        requestService = ServiceFactory.getRequestService();
        payrollService = ServiceFactory.getPayrollService();
        attendanceService = ServiceFactory.getAttendanceService();
    }

    // --- Added Methods to fix UI errors ---

    public boolean updateContact(int empId, String phone, String email) throws RequestNotFoundException {
        return employeeService.updateContact(empId, phone, email);
    }

    public List<Attendance> attendance(int empId, String month) throws AttendanceNotFoundException {
        return attendanceService.monthlyAttendance(empId, month);
    }

    public int getEmployeeId(String username) {
        return authService.getEmployeeId(username); 
    }

    public List<Leave> leaveHistory(int empId) throws InvalidLeaveException {
        return leaveService.viewLeaveHistory(empId);
    }

    // --- Standard Methods ---
    
    public boolean login(String username, String password) throws InvalidCredentialsException, UnauthorizedAccessException {
        return authService.login(username, password);
    }

    public boolean applyLeave(Leave leave) throws LeaveBalanceException, InvalidLeaveException, InvalidDateRangeException {
        return leaveService.applyLeave(leave);
    }

    public boolean uploadDocument(Document document) throws DocumentException, InvalidFileFormatException {
        return documentService.uploadDocument(document);
    }

    public Payroll viewPayslip(int empId, String month) throws PayrollUnavailableException {
        return payrollService.viewPayslip(empId, month);
    }

    public Employee viewProfile(int empId) throws RequestNotFoundException {
        return employeeService.viewProfile(empId);
    }

    public boolean submitRequest(Request request) throws RequestNotFoundException {
        return requestService.submitRequest(request);
    }

    public List<Request> viewRequests(int empId) throws RequestNotFoundException {
        return requestService.viewRequests(empId);
    }
}