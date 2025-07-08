package creationalpatterns.simplefactory;

// Implement a File Logger
/**
 * FileLogger is a concrete implementation of Logger that logs messages to a file.
 */
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // Simulate file logging (for simplicity, using System.out)
        System.out.println("File Logger: " + message);
    }
}