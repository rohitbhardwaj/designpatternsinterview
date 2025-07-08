package structuralpatterns.proxy;

/**
 * Subject interface defining the methods for database operations.
 */
public interface Database {
    void connect(); // Connect to the database
    void executeQuery(String query); // Execute a query
}
