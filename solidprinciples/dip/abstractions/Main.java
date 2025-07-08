package solidprinciples.dip.abstractions;

public class Main {
    public static void main(String[] args) {
        // Use EmailSender
        MessageSender emailSender = new EmailSender();
        NotificationService emailNotification = new NotificationService(emailSender);
        emailNotification.notifyUser("Hello via Email!");

        // Use SmsSender
        MessageSender smsSender = new SmsSender();
        NotificationService smsNotification = new NotificationService(smsSender);
        smsNotification.notifyUser("Hello via SMS!");
    }
}