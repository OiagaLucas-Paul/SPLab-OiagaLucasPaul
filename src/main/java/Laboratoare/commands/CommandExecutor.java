package Laboratoare.commands;

public interface CommandExecutor {
    <T> T execute(Command<T> command);
}
