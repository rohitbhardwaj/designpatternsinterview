package behavioralpatterns.command;

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