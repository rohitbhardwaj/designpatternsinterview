package creationalpatterns.singleton;

// Usage
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Eager Singleton initialized!");
    }
}