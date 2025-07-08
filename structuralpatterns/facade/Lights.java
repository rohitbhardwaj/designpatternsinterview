package structuralpatterns.facade;

public class Lights {
    public void dim(int level) {
        System.out.println("Lights dimmed to: " + level + "%.");
    }

    public void turnOn() {
        System.out.println("Lights are turned on.");
    }
}