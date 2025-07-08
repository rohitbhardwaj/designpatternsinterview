package structuralpatterns.bridge;

/**
 * Implementation interface for different file formats.
 */
public interface MediaFormat {
    void play(String filename); // Method to play a media file
}
