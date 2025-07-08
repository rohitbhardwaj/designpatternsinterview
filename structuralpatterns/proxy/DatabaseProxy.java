package structuralpatterns.proxy;

/**
 * Proxy class to control access to the RealDatabase.
 */
public class DatabaseProxy implements Database {
    private RealDatabase realDatabase; // Reference to the RealSubject
    private boolean hasAccess; // Access control flag

    public DatabaseProxy(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    @Override
    public void connect() {
        if (!hasAccess) {
            System.out.println("Access denied: You do not have permission to connect.");
            return;
        }

        if (realDatabase == null) {
            realDatabase = new RealDatabase(); // Lazy initialization
        }

        System.out.println("Proxy: Logging connection request.");
        realDatabase.connect();
    }

    @Override
    public void executeQuery(String query) {
        if (!hasAccess) {
            System.out.println("Access denied: You do not have permission to execute queries.");
            return;
        }

        if (realDatabase == null) {
            realDatabase = new RealDatabase(); // Lazy initialization
        }

        System.out.println("Proxy: Logging query execution.");
        realDatabase.executeQuery(query);
    }
}