package structuralpatterns.facade;

public class DVDPlayer {
    public void turnOn() {
        System.out.println("DVD Player is turned on.");
    }

    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void turnOff() {
        System.out.println("DVD Player is turned off.");
    }
}
