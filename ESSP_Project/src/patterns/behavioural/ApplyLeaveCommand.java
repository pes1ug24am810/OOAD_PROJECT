package patterns.behavioural;

import controller.ESSPFacade;
import model.Leave;
import javax.swing.JOptionPane;

public class ApplyLeaveCommand implements Command {

    private ESSPFacade facade;
    private Leave leave;

    public ApplyLeaveCommand(ESSPFacade facade, Leave leave) {
        this.facade = facade;
        this.leave = leave;
    }

    @Override
    public void execute() {
        try {
            // Checked exceptions must be caught because they aren't declared in the interface
            boolean success = facade.applyLeave(leave);
            
            if (success) {
                JOptionPane.showMessageDialog(null, "Leave application submitted successfully!");
            }
        } catch (exception.LeaveBalanceException | exception.InvalidLeaveException | exception.InvalidDateRangeException e) {
            // Handle the specific leave errors here
            JOptionPane.showMessageDialog(null, "Leave Error: " + e.getMessage(), "Application Failed", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Catch any other unexpected errors
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
        }
    }
}