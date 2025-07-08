package behavioralpatterns.state;

public class Main {
    public static void main(String[] args) { 
        TrafficLightContext trafficLight = new TrafficLightContext();

        // Simulate traffic light behavior
        trafficLight.request(); // Green light
        trafficLight.request(); // Yellow light
        trafficLight.request(); // Red light
        trafficLight.request(); // Back to Green light
    }
}