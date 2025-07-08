package creationalpatterns.singleton.lazysingleton;

/**
 * Logger class implementing Singleton using lazy initialization.
 * Advantages:

Instance is created only when needed, saving resources.
Disadvantage:

Not thread-safe by default.
 */
public class Logger {
    // Static instance initialized only when required
    private static Logger instance;

    // Private constructor to restrict instantiation
    private Logger() {}

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Instance created only when needed
        }
        return instance;
    }

    // Example method to log a message
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}