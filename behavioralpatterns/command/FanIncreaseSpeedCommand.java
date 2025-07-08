package behavioralpatterns.command;

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