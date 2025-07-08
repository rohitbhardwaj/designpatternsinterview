package creationalpatterns.factorymethod;

// Concrete Product: PDF Document
/**
 * PDFDocument is a specific implementation of the Document interface for PDF files.
 */
public class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}