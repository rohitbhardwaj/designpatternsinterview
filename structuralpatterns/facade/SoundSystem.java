package structuralpatterns.facade;

public class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is turned on.");
    }

    public void setVolume(int level) {
        System.out.println("Sound System volume set to: " + level);
    }

    public void turnOff() {
        System.out.println("Sound System is turned off.");
    }
}