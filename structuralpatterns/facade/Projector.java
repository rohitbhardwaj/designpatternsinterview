package structuralpatterns.facade;

public class Projector {
    public void turnOn() {
        System.out.println("Projector is turned on.");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }

    public void turnOff() {
        System.out.println("Projector is turned off.");
    }
}