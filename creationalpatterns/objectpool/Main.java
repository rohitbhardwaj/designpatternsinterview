package creationalpatterns.objectpool;

public class Main {
    public static void main(String[] args) {
        // Create a connection pool with 2 connections
        DatabaseConnectionPool pool = new DatabaseConnectionPool(2);

        // Acquire and use a connection
        DatabaseConnection connection1 = pool.acquireConnection();
        if (connection1 != null) {
            connection1.executeQuery("SELECT * FROM users");
        }

        // Acquire another connection
        DatabaseConnection connection2 = pool.acquireConnection();
        if (connection2 != null) {
            connection2.executeQuery("SELECT * FROM orders");
        }

        // Attempt to acquire a third connection (will fail)
        DatabaseConnection connection3 = pool.acquireConnection();

        // Release a connection and acquire again
        pool.releaseConnection(connection1);
        DatabaseConnection connection4 = pool.acquireConnection();
        if (connection4 != null) {
            connection4.executeQuery("SELECT * FROM products");
        }

                // Attempt to acquire a third connection (will fail)
                DatabaseConnection connectio11 = pool.acquireConnection();
                if (connectio11 != null) {
                    connectio11.executeQuery("SELECT * FROM YahooNFJS");
                }
    }
}
