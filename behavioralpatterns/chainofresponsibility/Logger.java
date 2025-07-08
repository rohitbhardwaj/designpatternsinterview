package behavioralpatterns.chainofresponsibility;

/**
 * Handler interface defining the contract for processing requests.
 */
public interface Logger {
    void log(String message, LogLevel level);
}
