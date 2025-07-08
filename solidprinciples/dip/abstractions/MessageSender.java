package solidprinciples.dip.abstractions;

/**
 * Abstraction for sending messages.
 */
public interface MessageSender {
    void sendMessage(String message);
}

