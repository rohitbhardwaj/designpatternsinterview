package behavioralpatterns.command;

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