Behavioral Design Patterns: Mediator Pattern
Objective
The Mediator Design Pattern centralizes communication between objects through a mediator, promoting loose coupling and better organization. Instead of objects interacting directly, they interact via a mediator, which simplifies dependencies and enhances maintainability.

What is the Mediator Pattern?
The Mediator Pattern is a behavioral design pattern that defines an intermediary object (the mediator) to encapsulate communication logic between components. This prevents tight coupling between objects, enabling more flexible and reusable designs.

Key Components
Mediator Interface:

Defines the communication contract between objects, specifying methods for interaction.
Concrete Mediator:

Implements the Mediator interface and coordinates communication among components.
Colleague:

Represents the objects or components that need to interact.
Concrete Colleague:

Implements specific functionality and relies on the mediator for communication with other colleagues.
When to Use the Mediator Pattern
Complex Communication:

When objects need to communicate in complex ways, and direct dependencies would result in a tightly coupled system.
Loose Coupling:

To decouple objects, ensuring they only interact through the mediator.
Centralized Control:

When you want a single entity to manage communication and behavior among objects.
Behavior Changes:

When frequent changes in behavior are expected, and you want to encapsulate those changes in the mediator.
When Not to Use the Mediator Pattern
Simple Interactions:

For straightforward communication, introducing a mediator may add unnecessary complexity.
Performance Concerns:

A mediator can introduce overhead, particularly in performance-critical systems.
Small-Scale Applications:

For small systems with minimal components, the added layer may not be justified.
Over-Engineering:

Avoid using the pattern when direct communication is sufficient and meets the system's needs.
Implementation
Use Case:
A Chat Room application where users (colleagues) communicate through a central chat room (mediator). Users send and receive messages only through the chat room, avoiding direct communication.

1. Mediator Interface
Define the interface for the mediator:

java
Copy code
/**
 * Mediator interface defining methods for communication.
 */
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
2. Concrete Mediator
Implement the mediator to coordinate communication:

java
Copy code
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
3. Colleague
Define an abstract colleague class:

java
Copy code
/**
 * Abstract colleague class representing a user.
 */
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
4. Concrete Colleague
Implement concrete user classes:

java
Copy code
/**
 * Concrete colleague class representing a user.
 */
public class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}
5. Client
Set up the chat room and user interactions:

java
Copy code
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
Output
plaintext
Copy code
Alice sends: Hello, everyone!
Bob receives: Hello, everyone!
Charlie receives: Hello, everyone!
Bob sends: Hi, Alice!
Alice receives: Hi, Alice!
Charlie receives: Hi, Alice!
Benefits of the Mediator Pattern
Loose Coupling:

Decouples components, promoting better organization and maintainability.
Centralized Logic:

Simplifies communication by centralizing interaction logic.
Improved Scalability:

Easier to add or modify colleagues without impacting others.
Behavior Encapsulation:

Changes in interaction logic are encapsulated in the mediator.
Challenges
Complex Mediator:

The mediator can become a god object, accumulating too much responsibility.
Performance Overhead:

Indirect communication may introduce delays compared to direct interactions.
Over-Engineering:

May add unnecessary complexity if the system doesn’t require centralized communication.
Real-World Applications
Chat Applications:

Chat rooms where users communicate indirectly through a central mediator.
UI Event Handling:

Mediating communication between different UI components like buttons and text fields.
Control Systems:

Centralized coordination of multiple subsystems, such as air traffic control systems.
Key Takeaways
The Mediator Pattern centralizes communication, reducing coupling between components.
It is particularly useful for systems with complex interactions or a need for scalable, organized communication.
Use judiciously to avoid over-engineering or creating a complex, bloated mediator.
