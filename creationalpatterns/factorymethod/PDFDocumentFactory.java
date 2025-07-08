package creationalpatterns.factorymethod;

// Concrete Creator: PDF Document Factory
/**
 * PDFDocumentFactory is responsible for creating PDF documents.
 */
public class PDFDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument(); // Create a PDF document
    }
}