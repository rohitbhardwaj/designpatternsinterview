package solidprinciples.dip;

/**
 * High-level module responsible for user notifications.
 * Why It Violates DIP
Direct Dependency: The NotificationService depends directly on the concrete EmailSender class.
Lack of Flexibility: If you want to send SMS or push notifications instead of email, the NotificationService code must be modified.
Testing Challenges: Testing the NotificationService requires real instances of EmailSender.
 */
public class NotificationService {
    private EmailSender emailSender;

    public NotificationService() {
        this.emailSender = new EmailSender(); // Tight coupling to the low-level module
    }

    public void notifyUser(String message) {
        emailSender.sendEmail(message); // Direct dependency on low-level module
    }
}