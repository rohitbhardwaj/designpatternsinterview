package behavioralpatterns.visitor;

/**
 * Concrete element representing a text file.
 */
public class TextFile implements File {
    private final String name;

    public TextFile(String name) {
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