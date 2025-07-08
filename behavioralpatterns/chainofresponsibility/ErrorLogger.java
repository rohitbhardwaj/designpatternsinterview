package behavioralpatterns.chainofresponsibility;

public class ErrorLogger extends AbstractLogger {
    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }
}