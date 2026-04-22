package repository.interfaces;

import model.Request;
import java.util.List;

public interface IRequestRepository {

    boolean createRequest(Request request);

    Request getRequestById(int requestId);

    List<Request> getRequestsByEmployee(int employeeId);

    boolean updateRequestStatus(int requestId, String status);

    boolean deleteRequest(int requestId);
}