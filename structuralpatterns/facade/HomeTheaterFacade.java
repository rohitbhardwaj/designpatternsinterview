package structuralpatterns.facade;

/**
 * Facade class to simplify interaction with the Home Theater System.
 */
public class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer;
    private final Projector projector;
    private final SoundSystem soundSystem;
    private final Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void startMovie(String movie) {
        System.out.println("\nSetting up the home theater system...");
        lights.dim(10);
        projector.turnOn();
        projector.setInput("DVD Player");
        soundSystem.turnOn();
        soundSystem.setVolume(20);
        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movie);
        System.out.println("Enjoy the movie!");
    }

    public void endMovie() {
        System.out.println("\nShutting down the home theater system...");
        dvdPlayer.turnOff();
        projector.turnOff();
        soundSystem.turnOff();
        lights.turnOn();
        System.out.println("Goodbye!");
    }
}