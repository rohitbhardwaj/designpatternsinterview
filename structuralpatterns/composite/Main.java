package structuralpatterns.composite;
public class Main {
    public static void main(String[] args) {
        // Create leaf components (files)
        FileSystemComponent file1 = new File("Document1.txt");
        FileSystemComponent file2 = new File("Document2.txt");
        FileSystemComponent file3 = new File("Picture1.jpg");

        // Create composite components (directories)
        Directory documents = new Directory("Documents");
        Directory pictures = new Directory("Pictures");
        Directory root = new Directory("Root");

        // Build the tree structure
        documents.addComponent(file1);
        documents.addComponent(file2);
        pictures.addComponent(file3);
        root.addComponent(documents);
        root.addComponent(pictures);

        // Display details of the entire file system
        root.showDetails();
    }
}
