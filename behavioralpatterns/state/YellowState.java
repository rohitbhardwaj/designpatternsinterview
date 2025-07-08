package behavioralpatterns.state;

/**
 * Concrete state representing the Yellow light.
 */
public class YellowState implements TrafficLightState {
    private final TrafficLightContext context;

    public YellowState(TrafficLightContext context) {
        this.context = context;
    }

    @Override
    public void handleRequest() {
        System.out.println("Yellow light: Cars should prepare to stop.");
        context.setState(new RedState(context)); // Transition to Red
    }
}