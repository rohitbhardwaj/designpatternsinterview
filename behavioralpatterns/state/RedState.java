package behavioralpatterns.state;

/**
 * Concrete state representing the Red light.
 */
public class RedState implements TrafficLightState {
    private final TrafficLightContext context;

    public RedState(TrafficLightContext context) {
        this.context = context;
    }

    @Override
    public void handleRequest() {
        System.out.println("Red light: Cars must stop.");
        context.setState(new GreenState(context)); // Transition to Green
    }
}