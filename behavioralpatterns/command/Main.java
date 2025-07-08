package behavioralpatterns.command;

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