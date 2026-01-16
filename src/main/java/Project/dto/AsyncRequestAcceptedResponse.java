package Project.dto;

public class AsyncRequestAcceptedResponse {
    private String requestId;

    public AsyncRequestAcceptedResponse() {}

    public AsyncRequestAcceptedResponse(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
}
