package behavioralpatterns.command;

/**
 * Command interface defining the execute method.
 */
public interface Command {
    void execute();
    void undo(); // Support for undoable operations
}
