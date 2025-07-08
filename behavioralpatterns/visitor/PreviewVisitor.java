package behavioralpatterns.visitor;

/**
 * Concrete visitor for previewing files.
 */
public class PreviewVisitor implements FileVisitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Previewing text file: " + textFile.getName());
    }

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Previewing image file: " + imageFile.getName());
    }
}