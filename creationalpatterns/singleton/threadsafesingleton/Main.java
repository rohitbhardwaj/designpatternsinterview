package creationalpatterns.singleton.threadsafesingleton;

// Usage
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Thread-safe Singleton initialized!");
    }
}