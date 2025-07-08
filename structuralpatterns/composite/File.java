package structuralpatterns.composite;

/**
 * Leaf representing a file in the file system.
 */
public class File implements FileSystemComponent {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}