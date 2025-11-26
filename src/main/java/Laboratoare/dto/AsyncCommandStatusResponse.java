package Laboratoare.dto;

import Laboratoare.async.AsyncStatus;

import java.util.UUID;

public class AsyncCommandStatusResponse {

    private UUID id;
    private AsyncStatus status;
    private Object result;
    private String errorMessage;

    public AsyncCommandStatusResponse() {
    }

    public AsyncCommandStatusResponse(UUID id, AsyncStatus status, Object result, String errorMessage) {
        this.id = id;
        this.status = status;
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AsyncStatus getStatus() {
        return status;
    }

    public void setStatus(AsyncStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
