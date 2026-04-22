package service.interfaces;

import model.Request;
import java.util.List;

import exception.RequestNotFoundException;

public interface IRequestService {

    boolean submitRequest(Request request)
            throws RequestNotFoundException;

    List<Request> viewRequests(int employeeId)
            throws RequestNotFoundException;

    boolean cancelRequest(int requestId)
            throws RequestNotFoundException;
}