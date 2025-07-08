Behavioral Design Patterns: Command Pattern
Objective
The Command Design Pattern encapsulates a request as an object, allowing for parameterization of requests, queuing or logging requests, and support for undoable operations. This pattern decouples the object that sends a request (Invoker) from the object that executes it (Receiver), enabling flexible and extensible systems.

What is the Command Pattern?
Encapsulation: Turns a request into a stand-alone object called a command.
Decoupling: Separates the sender and receiver, allowing them to evolve independently.
Undo/Redo Support: Enables undoable actions by storing the state or reverse commands.
Key Components
Command Interface:

Declares the execute() method that all concrete commands must implement.
Concrete Command:

Encapsulates specific requests, delegating execution to a receiver.
Receiver:

Contains the actual business logic to execute the command.
Invoker:

Holds references to commands and triggers their execution.
Client:

Creates concrete command objects, associates them with receivers, and assigns commands to the invoker.
When to Use Command Pattern
Decoupling Needed:

When the sender of a request should not know about the specific receiver.
Undo/Redo Functionality:

When applications require reversible operations.
Request Logging:

When requests need to be logged, queued, or executed later.
Dynamic Configuration:

When requests must be dynamically configured at runtime.
Implementation
Use Case:
A Remote Control system with commands to turn on/off lights and increase/decrease the fan speed. The commands are encapsulated and executed through a unified interface.

1. Command Interface
Define the common interface for all commands:

java
Copy code
/**
 * Command interface defining the execute method.
 */
public interface Command {
    void execute();
    void undo(); // Support for undoable operations
}
2. Receiver
Implement the business logic for the lights and fan:

Light:

java
Copy code
/**
 * Receiver class representing a light.
 */
public class Light {
    public void turnOn() {
        System.out.println("Light is turned ON.");
    }

    public void turnOff() {
        System.out.println("Light is turned OFF.");
    }
}
Fan:

java
Copy code
/**
 * Receiver class representing a fan.
 */
public class Fan {
    private int speed = 0;

    public void increaseSpeed() {
        speed++;
        System.out.println("Fan speed increased to: " + speed);
    }

    public void decreaseSpeed() {
        speed = Math.max(speed - 1, 0);
        System.out.println("Fan speed decreased to: " + speed);
    }
}
3. Concrete Commands
Encapsulate specific requests for the light and fan:

Light Commands:

java
Copy code
/**
 * Concrete command to turn on the light.
 */
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

/**
 * Concrete command to turn off the light.
 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
Fan Commands:

java
Copy code
/**
 * Concrete command to increase the fan speed.
 */
public class FanIncreaseSpeedCommand implements Command {
    private final Fan fan;

    public FanIncreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.increaseSpeed();
    }

    @Override
    public void undo() {
        fan.decreaseSpeed();
    }
}

/**
 * Concrete command to decrease the fan speed.
 */
public class FanDecreaseSpeedCommand implements Command {
    private final Fan fan;

    public FanDecreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.decreaseSpeed();
    }

    @Override
    public void undo() {
        fan.increaseSpeed();
    }
}
4. Invoker
The invoker triggers command execution:

java
Copy code
/**
 * Invoker class representing a remote control.
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }

    public void pressUndo() {
        if (command != null) {
            command.undo();
        }
    }
}
5. Client
The client sets up the system:

java
Copy code
public class Main {
    public static void main(String[] args) {
        // Receivers
        Light light = new Light();
        Fan fan = new Fan();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanIncrease = new FanIncreaseSpeedCommand(fan);
        Command fanDecrease = new FanDecreaseSpeedCommand(fan);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Use the remote control to operate the light
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is turned ON.
        remote.pressUndo();   // Output: Light is turned OFF.

        // Use the remote control to operate the fan
        remote.setCommand(fanIncrease);
        remote.pressButton(); // Output: Fan speed increased to: 1
        remote.pressUndo();   // Output: Fan speed decreased to: 0
    }
}
Output
plaintext
Copy code
Light is turned ON.
Light is turned OFF.
Fan speed increased to: 1
Fan speed decreased to: 0
Benefits of Command Pattern
Decoupling:

Separates the invoker and receiver, making the system more flexible and maintainable.
Undo/Redo:

Supports undoable operations by storing state or reverse commands.
Extensibility:

Easily add new commands without modifying existing code.
Request Logging:

Commands can be logged or queued for future execution.
Challenges
Complexity:

Introduces additional classes and abstractions, which can be overkill for simple systems.
Memory Overhead:

Maintaining command objects can increase memory usage.
When Not to Use Command Pattern
Simple Operations:

For basic operations where sender and receiver can interact directly.
Performance-Critical Systems:

Avoid in systems where the overhead of creating command objects impacts performance.
Real-World Applications
GUI Button Actions:

Encapsulate button actions as commands (e.g., Save, Open, Close).
Text Editors:

Implement undo/redo functionality.
Task Scheduling:

Queue and execute tasks as commands in job schedulers.
Key Takeaways
The Command Pattern encapsulates requests as objects, enabling decoupling, undo/redo, and dynamic configuration.
It is ideal for complex systems requiring flexibility, extensibility, and state management.
Use this pattern judiciously when its benefits outweigh the added complexity.

