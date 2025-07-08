package creationalpatterns.singleton;

/**
 * Logger class implementing Singleton using eager initialization.
 * Eager Initialization Singleton
 * Advantages:

Simple and thread-safe.
Instance is created when the class is loaded.
Disadvantage:

Instance is created even if it’s never used, which can lead to resource wastage.
 */
public class Logger {
    // Static instance created at the time of class loading
    private static final Logger instance = new Logger();

    // Private constructor to restrict instantiation
    private Logger() {}

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        return instance;
    }

    // Example method to log a message
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

