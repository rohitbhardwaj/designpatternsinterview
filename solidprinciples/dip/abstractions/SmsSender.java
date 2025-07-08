package solidprinciples.dip.abstractions;

/**
 * Low-level module for sending SMS.
 */
public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}