
package solidprinciples.interfacea;

/**
 * Interface representing general actions for machines.
 */
public interface Machine {
    /**
     * Start the machine.
     */
    void start();

    /**
     * Stop the machine.
     */
    void stop();

    /**
     * Print a document (relevant only for printers).
     * 
     * @param document the document to print.
     */
    void print(String document);
}
