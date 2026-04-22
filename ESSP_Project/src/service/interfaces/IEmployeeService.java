package service.interfaces;

import model.Employee;

import exception.RequestNotFoundException;

public interface IEmployeeService {

    Employee viewProfile(int employeeId)
            throws RequestNotFoundException;

    boolean updateProfile(Employee employee)
            throws RequestNotFoundException;

    boolean updateContact(int employeeId,
                          String phone,
                          String email)
            throws RequestNotFoundException;
}