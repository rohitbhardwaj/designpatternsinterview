package behavioralpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Mediator implementation for a chat room.
 */
public class ChatRoom implements ChatMediator {
    private final List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Ensure the sender does not receive their own message
            if (u != user) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
