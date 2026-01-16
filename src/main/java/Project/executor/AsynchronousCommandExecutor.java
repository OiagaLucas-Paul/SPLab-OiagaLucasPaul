package Project.executor;

import Project.commands.Command;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsynchronousCommandExecutor {

    private final ExecutorService pool = Executors.newFixedThreadPool(4);
    private final AsyncRequestStore asyncRequestStore;

    public AsynchronousCommandExecutor(AsyncRequestStore asyncRequestStore) {
        this.asyncRequestStore = asyncRequestStore;
    }

    public String submit(Command<?> command) {
        String requestId = asyncRequestStore.createPending();

        pool.submit(() -> {
            try {
                Object result = command.execute();
                asyncRequestStore.completeSuccess(requestId, result);
            } catch (Exception e) {
                asyncRequestStore.completeError(requestId, e.getMessage());
            }
        });

        return requestId;
    }
}
