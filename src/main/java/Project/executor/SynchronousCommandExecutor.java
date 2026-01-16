package Project.executor;

import Project.commands.Command;
import org.springframework.stereotype.Component;

@Component
public class SynchronousCommandExecutor implements CommandExecutor {

    @Override
    public <T> T execute(Command<T> command) {
        return command.execute();
    }
}
