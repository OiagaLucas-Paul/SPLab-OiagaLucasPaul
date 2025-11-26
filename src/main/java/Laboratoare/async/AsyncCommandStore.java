package Laboratoare.async;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AsyncCommandStore {

    private final Map<UUID, AsyncCommandResult<?>> store = new ConcurrentHashMap<>();

    public <T> void put(AsyncCommandResult<T> result) {
        store.put(result.getId(), result);
    }

    @SuppressWarnings("unchecked")
    public <T> AsyncCommandResult<T> get(UUID id) {
        return (AsyncCommandResult<T>) store.get(id);
    }
}
