package creationalpatterns.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Object pool managing reusable database connections.
 */
public class DatabaseConnectionPool {
    private final List<DatabaseConnection> connections;
    private final int maxPoolSize;

    public DatabaseConnectionPool(int maxPoolSize) {
        this.connections = new ArrayList<>();
        this.maxPoolSize = maxPoolSize;

        // Initialize the pool with connections
        for (int i = 0; i < maxPoolSize; i++) {
            connections.add(new DatabaseConnection());
        }
    }

    // Method to acquire a connection
    public synchronized DatabaseConnection acquireConnection() {
        for (DatabaseConnection connection : connections) {
            if (!connection.isInUse()) {
                connection.setInUse(true);
                return connection;
            }
        }
        System.out.println("No available connections.");
        return null;
    }

    // Method to release a connection back to the pool
    public synchronized void releaseConnection(DatabaseConnection connection) {
        connection.setInUse(false);
    }
}
