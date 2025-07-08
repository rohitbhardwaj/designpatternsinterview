package creationalpatterns.factorymethod;

/**
 * Abstract class representing the Document Factory.
 * Defines the factory method for creating documents.
 */
public abstract class DocumentFactory {
    /**
     * Factory method to create a Document.
     * 
     * @return A Document instance.
     */
    public abstract Document createDocument();

    /**
     * A method that demonstrates working with a document.
     */
    public void openDocument() {
        Document doc = createDocument(); // Call the factory method
        doc.open(); // Use the created document
    }
}