package creationalpatterns.prototype;

public class Main {
    public static void main(String[] args) {
        // Create an original Document
        Document originalDocument = new Document("Design Patterns", "Prototype Pattern Example");

        // Clone the original Document
        Document clonedDocument = (Document) originalDocument.clone();

        // Modify the cloned Document
        clonedDocument.setTitle("Cloned Document");

        // Display original and cloned Documents
        System.out.println("Original Document: " + originalDocument);
        System.out.println("Cloned Document: " + clonedDocument);
    }
}