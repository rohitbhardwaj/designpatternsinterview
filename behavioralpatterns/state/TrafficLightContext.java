package behavioralpatterns.state;

/**
 * Context class for the traffic light system.
 */
public class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        // Initial state
        currentState = new GreenState(this);
    }

    public void setState(TrafficLightState state) { 
        currentState = state;
    }

    public void request() {
        currentState.handleRequest();
    }
}