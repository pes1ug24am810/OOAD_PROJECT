package service.impl;

import model.Request;
import service.interfaces.IRequestService;
import repository.interfaces.IRequestRepository;
import exception.RequestNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class RequestServiceImpl implements IRequestService {
    private IRequestRepository repo;

    public RequestServiceImpl(IRequestRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean submitRequest(Request request) throws RequestNotFoundException {
        if (request == null) {
            throw new IllegalArgumentException("Request is null.");
        }

        if (request.getEmployeeId() <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        if (request.getRequestType() == null || request.getRequestType().isEmpty()) {
            throw new IllegalArgumentException("Request type required.");
        }

        request.setStatus("PENDING");
        request.setCreatedOn(LocalDate.now().toString());

        boolean result = repo.createRequest(request);
        if (!result) {
            throw new RequestNotFoundException("Request submission failed.");
        }
        return true;
    }

    @Override
    public List<Request> viewRequests(int employeeId) throws RequestNotFoundException {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        List<Request> list = repo.getRequestsByEmployee(employeeId);
        if (list == null || list.isEmpty()) {
            throw new RequestNotFoundException("No requests found.");
        }
        return list;
    }

    @Override
    public boolean cancelRequest(int requestId) throws RequestNotFoundException {
        if (requestId <= 0) {
            throw new IllegalArgumentException("Invalid request ID.");
        }

        boolean result = repo.deleteRequest(requestId);
        if (!result) {
            throw new RequestNotFoundException("Request not found or cannot delete.");
        }
        return true;
    }
}