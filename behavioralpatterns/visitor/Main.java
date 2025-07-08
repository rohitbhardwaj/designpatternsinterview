package behavioralpatterns.visitor;

public class Main {
    public static void main(String[] args) {
        // Create file system and add files
        FileSystem fileSystem = new FileSystem();
        fileSystem.addFile(new TextFile("document.txt"));
        fileSystem.addFile(new ImageFile("photo.jpg"));

        // Process files with a compression visitor
        System.out.println("Compressing Files:");
        FileVisitor compressionVisitor = new CompressionVisitor();
        fileSystem.processFiles(compressionVisitor);

        System.out.println();

        // Process files with a preview visitor
        System.out.println("Previewing Files:");
        FileVisitor previewVisitor = new PreviewVisitor();
        fileSystem.processFiles(previewVisitor);
    }
}