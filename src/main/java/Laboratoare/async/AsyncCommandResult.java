package Laboratoare.async;

import java.util.UUID;

public class AsyncCommandResult<T> {
    private final UUID id;
    private AsyncStatus status;
    private T result;
    private Throwable error;

    public AsyncCommandResult(UUID id) {
        this.id = id;
        this.status = AsyncStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public AsyncStatus getStatus() {
        return status;
    }

    public void setStatus(AsyncStatus status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}
