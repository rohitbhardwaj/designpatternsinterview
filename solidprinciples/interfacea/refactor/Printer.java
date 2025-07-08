package solidprinciples.interfacea.refactor;


/**
 * Printer class implementing BasicMachine and Printable.
 */
public class Printer implements BasicMachine, Printable {
    @Override
    public void start() {
        System.out.println("Printer starting...");
    }

    @Override
    public void stop() {
        System.out.println("Printer stopping...");
    }

    @Override
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }
}