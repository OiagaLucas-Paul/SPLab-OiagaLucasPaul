package Project.executor;

import Project.dto.AsyncCommandStatusResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static Project.dto.AsyncCommandStatusResponse.Status;

@Component
public class AsyncRequestStore {

    private final Map<String, AsyncCommandStatusResponse> store = new ConcurrentHashMap<>();

    public String createPending() {
        String id = UUID.randomUUID().toString();
        store.put(id, new AsyncCommandStatusResponse(id, Status.PENDING, null, null));
        return id;
    }

    public void completeSuccess(String id, Object result) {
        store.put(id, new AsyncCommandStatusResponse(id, Status.SUCCESS, result, null));
    }

    public void completeError(String id, String error) {
        store.put(id, new AsyncCommandStatusResponse(id, Status.ERROR, null, error));
    }

    public AsyncCommandStatusResponse get(String id) {
        return store.get(id);
    }
}
