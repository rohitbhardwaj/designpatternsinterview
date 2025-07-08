package creationalpatterns.simplefactory;

// Create the Simple Factory
/**
 * LoggerFactory is a factory class responsible for creating logger instances.
 */
public class LoggerFactory {
    /**
     * Factory method to create a logger based on the type specified.
     * 
     * @param type The type of logger to create ("console" or "file").
     * @return An instance of Logger.
     */
    public static Logger createLogger(String type) {
        if ("console".equalsIgnoreCase(type)) {
            return new ConsoleLogger();
        } else if ("file".equalsIgnoreCase(type)) {
            return new FileLogger();
        }
        throw new IllegalArgumentException("Unknown logger type: " + type);
    }
}