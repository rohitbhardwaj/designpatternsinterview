package structuralpatterns.bridge;

/**
 * Refined abstraction for a video player.
 */
public class VideoPlayer extends MediaPlayer {
    public VideoPlayer(MediaFormat mediaFormat) {
        super(mediaFormat);
    }

    @Override
    public void play(String filename) {
        System.out.println("Video Player in action...");
        mediaFormat.play(filename);
    }
}