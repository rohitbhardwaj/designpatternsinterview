package behavioralpatterns.mediator;

public class Main {
    public static void main(String[] args) {
        // Create mediator
        ChatMediator chatRoom = new ChatRoom();

        // Create users
        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");

        // Add users to the chat room
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        // Users communicate through the chat room
        user1.send("Hello, everyone!");
        user2.send("Hi, Alice!");
    }
}