package behavioralpatterns.visitor;

/**
 * Concrete element representing an image file.
 */
public class ImageFile implements File {
    private final String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void accept(FileVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }
}