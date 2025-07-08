package creationalpatterns.simplefactory;

// Demonstrate the Simple Factory in action
/**
 * Main class demonstrating the use of Simple Factory to create and use loggers.
 * Encapsulation of Object Creation:
Clients only call the factory; they don’t need to know the details of object instantiation.
 * Centralized Creation Logic:
If you need to change how objects are created, you do so in one place.
Flexibility:
Adding new loggers (e.g., DatabaseLogger) requires changes only in the factory without modifying existing client code.

 */
public class Main {
    public static void main(String[] args) {
        // Create a console logger using the factory
        Logger consoleLogger = LoggerFactory.createLogger("console");
        consoleLogger.log("This is a message to the console logger.");

        // Create a file logger using the factory
        Logger fileLogger = LoggerFactory.createLogger("file");
        fileLogger.log("This is a message to the file logger.");

        // Attempting to create an unsupported logger type
        try {
            Logger unknownLogger = LoggerFactory.createLogger("database");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}