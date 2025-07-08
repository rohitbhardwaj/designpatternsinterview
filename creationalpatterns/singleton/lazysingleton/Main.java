package creationalpatterns.singleton.lazysingleton;



// Usage
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Lazy Singleton initialized!");
    }
}
