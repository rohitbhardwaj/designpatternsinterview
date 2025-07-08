package structuralpatterns.bridge;

/**
 * Concrete implementation for MP3 format.
 */
public class MP3Format implements MediaFormat {
    @Override
    public void play(String filename) {
        System.out.println("Playing MP3 file: " + filename);
    }
}