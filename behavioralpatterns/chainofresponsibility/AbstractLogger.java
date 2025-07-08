package behavioralpatterns.chainofresponsibility;

/**
 * Abstract logger that defines the chain mechanism.
 */
public abstract class AbstractLogger implements Logger {
    protected AbstractLogger nextLogger; // Next logger in the chain

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    protected abstract void write(String message); // Abstract method to write the log

    @Override
    public void log(String message, LogLevel level) {
        if (canHandle(level)) {
            write(message);
        } else if (nextLogger != null) {
            nextLogger.log(message, level);
        }
    }

    protected abstract boolean canHandle(LogLevel level); // Determines if the logger can handle the level
}