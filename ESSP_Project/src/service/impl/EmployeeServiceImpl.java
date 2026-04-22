package service.impl;

import org.hibernate.Session;
import utils.HibernateUtil;

// REPLACE THESE with the actual entity imports from the JAR
import com.hrms.db.entities.Employee; 

public class EmployeeServiceImpl {

    public Employee getEmployeeProfile(int employeeId) {
        Employee employee = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            // Fetch the employee by their Primary Key (ID)
            employee = session.get(Employee.class, employeeId);
            
        } catch (Exception e) {
            System.err.println("Error fetching employee profile:");
            e.printStackTrace();
        }
        
        return employee;
    }
    
    // Example of an update method
    public void updateEmployeeContact(int employeeId, String newPhone) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                employee.setPhone(newPhone); // Assuming the JAR has a setPhone method
                session.update(employee);
            }
            
            session.getTransaction().commit(); // Save changes to the database
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}