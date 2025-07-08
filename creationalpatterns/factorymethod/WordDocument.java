package creationalpatterns.factorymethod;

// Concrete Product: Word Document
/**
 * WordDocument is a specific implementation of the Document interface for Word files.
 */
public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a Word document.");
    }
}