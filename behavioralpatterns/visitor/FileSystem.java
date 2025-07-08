package behavioralpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Object structure for managing files.
 */
public class FileSystem {
    private final List<File> files = new ArrayList<>();

    public void addFile(File file) {
        files.add(file);
    }

    public void processFiles(FileVisitor visitor) {
        for (File file : files) {
            file.accept(visitor);
        }
    }
}
