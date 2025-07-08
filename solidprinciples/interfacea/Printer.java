package solidprinciples.interfacea;


/**
 * A Printer class implementing Machine interface.
 */
public class Printer implements Machine {
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