package structuralpatterns.proxy;

/**
 * RealSubject representing the actual database connection.
 */
public class RealDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to the database...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}