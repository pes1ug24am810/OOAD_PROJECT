import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// import com.otherteam.hrms.entity.Employee;

public class EmployeeSelfServiceApp {
    public static void main(String[] args) {
        System.out.println("Starting Employee Self-Service Portal...");
        System.out.println("Attempting to connect to HRMS Database...");

        SessionFactory factory = null;
        Session session = null;

        try {
            // 1. Build the SessionFactory. 
            // This automatically reads the 'hibernate.cfg.xml' inside the JAR.
            factory = new Configuration().configure().buildSessionFactory();
            
            // 2. Open a session to interact with the SQLite database
            session = factory.openSession();
            session.beginTransaction();

            System.out.println("Connection Successful! Ready to fetch data.");

            // ---------------------------------------------------------
            // 3. FETCH YOUR DATA HERE
            // ---------------------------------------------------------
            /* Example of how we will get the data once you know the class name:
               
               List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
               
               for (Employee emp : employees) {
                   System.out.println("Loaded Employee: " + emp.getName()); // Assuming a getName() method
               }
            */

            // Commit transaction and clean up
            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Database connection failed. Check errors below:");
            e.printStackTrace();
        } finally {
            // 4. Close connections to prevent memory leaks
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
