package Laboratoare.dto;

import java.util.UUID;

public class AsyncRequestAcceptedResponse {

    private UUID requestId;

    public AsyncRequestAcceptedResponse() {
    }

    public AsyncRequestAcceptedResponse(UUID requestId) {
        this.requestId = requestId;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }
}
