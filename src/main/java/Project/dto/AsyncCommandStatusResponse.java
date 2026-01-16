package Project.dto;

public class AsyncCommandStatusResponse {

    public enum Status {
        PENDING,
        SUCCESS,
        ERROR
    }

    private String requestId;
    private Status status;
    private Object result;
    private String error;

    public AsyncCommandStatusResponse() {}

    public AsyncCommandStatusResponse(String requestId, Status status, Object result, String error) {
        this.requestId = requestId;
        this.status = status;
        this.result = result;
        this.error = error;
    }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Object getResult() { return result; }
    public void setResult(Object result) { this.result = result; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}
