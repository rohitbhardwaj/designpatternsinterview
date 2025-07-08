package creationalpatterns.simplefactory;

// Implement a Console Logger
/**
 * ConsoleLogger is a concrete implementation of Logger that logs messages to the console.
 */
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Console Logger: " + message);
    }
}