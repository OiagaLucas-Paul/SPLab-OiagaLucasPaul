package Project.executor;

import Project.commands.Command;

public interface CommandExecutor {
    <T> T execute(Command<T> command);
}
