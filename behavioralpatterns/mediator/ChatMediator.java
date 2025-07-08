package behavioralpatterns.mediator;

/**
 * Mediator interface defining methods for communication.
 */
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
