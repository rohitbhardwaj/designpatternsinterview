package behavioralpatterns.state;

/**
 * Concrete state representing the Green light.
 */
public class GreenState implements TrafficLightState {
    private final TrafficLightContext context;

    public GreenState(TrafficLightContext context) {
        this.context = context;
    }

    @Override
    public void handleRequest() {
        System.out.println("Green light: Cars can go.");
        context.setState(new YellowState(context)); // Transition to Yellow
    }
}