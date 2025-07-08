package behavioralpatterns.chainofresponsibility;

public class DebugLogger extends AbstractLogger {
    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }
}