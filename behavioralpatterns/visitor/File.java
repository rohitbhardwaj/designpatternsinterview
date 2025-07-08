package behavioralpatterns.visitor;

/**
 * Element interface for file types.
 */
public interface File {
    void accept(FileVisitor visitor);
    String getName();
}