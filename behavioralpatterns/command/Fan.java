package behavioralpatterns.command;

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