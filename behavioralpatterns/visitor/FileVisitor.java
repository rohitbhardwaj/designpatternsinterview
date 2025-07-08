package behavioralpatterns.visitor;

/**
 * Visitor interface with methods for different file types.
 */
public interface FileVisitor {
    void visit(TextFile textFile);
    void visit(ImageFile imageFile);
}

