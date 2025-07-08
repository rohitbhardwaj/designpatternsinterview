package solidprinciples.dip.abstractions;

/**
 * High-level module depending on abstraction (MessageSender).
 */
public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender; // Dependency injection
    }

    public void notifyUser(String message) {
        messageSender.sendMessage(message); // Uses abstraction
    }
}