package creationalpatterns.factorymethod;

// Concrete Creator: Word Document Factory
/**
 * WordDocumentFactory is responsible for creating Word documents.
 */
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument(); // Create a Word document
    }
}