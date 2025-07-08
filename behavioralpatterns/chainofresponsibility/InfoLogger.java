package behavioralpatterns.chainofresponsibility;

public class InfoLogger extends AbstractLogger {
    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.INFO;
    }
}