package Laboratoare.async;

import Laboratoare.commands.Command;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsynchronousCommandExecutor {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private final AsyncCommandStore asyncCommandStore;

    public AsynchronousCommandExecutor(AsyncCommandStore asyncCommandStore) {
        this.asyncCommandStore = asyncCommandStore;
    }

    public <T> UUID submit(Command<T> command) {
        UUID id = UUID.randomUUID();
        AsyncCommandResult<T> resultHolder = new AsyncCommandResult<>(id);
        asyncCommandStore.put(resultHolder);

        executorService.submit(() -> {
            resultHolder.setStatus(AsyncStatus.RUNNING);
            try {
                T result = command.execute();
                resultHolder.setResult(result);
                resultHolder.setStatus(AsyncStatus.COMPLETED);
            } catch (Throwable t) {
                resultHolder.setError(t);
                resultHolder.setStatus(AsyncStatus.FAILED);
            }
        });

        return id;
    }
}
