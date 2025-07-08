package creationalpatterns.factorymethod;

/**
 * Main class demonstrating the Factory Method Design Pattern.
 */
public class Main {
    public static void main(String[] args) {
        // Use PDF Document Factory
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        pdfFactory.openDocument(); // Outputs: Opening a PDF document.

        // Use Word Document Factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.openDocument(); // Outputs: Opening a Word document.
    }
}