package creationalpatterns.singleton.threadsafesingleton;

/**
 * Logger class implementing Singleton using thread safety.
 * Advantages:

Ensures thread safety while minimizing performance overhead.
Disadvantage:

Slightly more complex implementation.
 */
public class Logger {
    // Static instance with volatile to ensure visibility across threads
    private static volatile Logger instance;

    // Private constructor to restrict instantiation
    private Logger() {}

    // Double-checked locking to ensure thread safety
    public static Logger getInstance() {
        if (instance == null) { // First check
            synchronized (Logger.class) {
                if (instance == null) { // Second check inside synchronized block
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example method to log a message
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
