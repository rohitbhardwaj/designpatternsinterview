package structuralpatterns.bridge;

/**
 * Refined abstraction for an audio player.
 */
public class AudioPlayer extends MediaPlayer {
    public AudioPlayer(MediaFormat mediaFormat) {
        super(mediaFormat);
    }

    @Override
    public void play(String filename) {
        System.out.println("Audio Player in action...");
        mediaFormat.play(filename);
    }
}