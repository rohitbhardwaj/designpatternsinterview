package solidprinciples.dip.abstractions;

/**
 * Low-level module for sending emails.
 */
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}