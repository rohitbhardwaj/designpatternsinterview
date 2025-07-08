package structuralpatterns.bridge;

public class Main {
    public static void main(String[] args) {
        // Create an MP3 format
        MediaFormat mp3Format = new MP3Format();

        // Create an MP4 format
        MediaFormat mp4Format = new MP4Format();

        // Create an Audio Player with MP3 format
        MediaPlayer audioPlayer = new AudioPlayer(mp3Format);
        audioPlayer.play("song.mp3");

        // Create a Video Player with MP4 format
        MediaPlayer videoPlayer = new VideoPlayer(mp4Format);
        videoPlayer.play("movie.mp4");

        // Change the format dynamically
        MediaPlayer audioPlayerWithMP4 = new AudioPlayer(mp4Format);
        audioPlayerWithMP4.play("lecture.mp4");
    }
}