package creationalpatterns.simplefactory;

// Define the abstraction/interface for a logger
/**
 * Logger interface that defines the contract for logging messages.
 */
public interface Logger {
    /**
     * Logs a message.
     * 
     * @param message The message to log.
     */
    void log(String message);
}
