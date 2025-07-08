package structuralpatterns.bridge;

/**
 * Concrete implementation for MP4 format.
 */
public class MP4Format implements MediaFormat {
    @Override
    public void play(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}