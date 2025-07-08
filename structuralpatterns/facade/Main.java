package structuralpatterns.facade;

public class Main {
    public static void main(String[] args) {
        // Create subsystem components
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights);

        // Use the facade to start and end a movie
        homeTheater.startMovie("Inception");
        homeTheater.endMovie();
    }
}