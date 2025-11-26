package Laboratoare.commands;

import org.springframework.stereotype.Component;

@Component
public class SynchronousCommandExecutor implements CommandExecutor {

    @Override
    public <T> T execute(Command<T> command) {
        return command.execute();
    }
}
