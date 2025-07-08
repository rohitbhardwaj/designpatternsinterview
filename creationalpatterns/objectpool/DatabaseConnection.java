package creationalpatterns.objectpool;

/**
 * DatabaseConnection simulates a reusable object for database operations.
 */
public class DatabaseConnection {
    private boolean inUse;

    public DatabaseConnection() {
        this.inUse = false;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}

