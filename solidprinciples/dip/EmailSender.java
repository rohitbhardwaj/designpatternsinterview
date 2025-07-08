package solidprinciples.dip;

/**
 * Low-level module responsible for sending emails.
 */
public class EmailSender {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}