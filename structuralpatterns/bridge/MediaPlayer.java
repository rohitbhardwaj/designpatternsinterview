package structuralpatterns.bridge;

/**
 * Abstraction class for a media player.
 */
public abstract class MediaPlayer {
    protected MediaFormat mediaFormat; // Reference to the implementation

    public MediaPlayer(MediaFormat mediaFormat) {
        this.mediaFormat = mediaFormat;
    }

    public abstract void play(String filename); // Abstract method to play a file
}