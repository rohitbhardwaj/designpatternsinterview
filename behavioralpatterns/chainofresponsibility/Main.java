package behavioralpatterns.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        // Create loggers
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger errorLogger = new ErrorLogger();

        // Set up the chain
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);

        // Log messages
        debugLogger.log("This is a debug message", LogLevel.DEBUG);
        debugLogger.log("This is an info message", LogLevel.INFO);
        debugLogger.log("This is an error message", LogLevel.ERROR);
    }
}