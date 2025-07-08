package structuralpatterns.proxy;

public class LoggingProxy implements Database {
    private final Database next;

    public LoggingProxy(Database next) {
        this.next = next;
    }

    @Override
    public void connect() {
        System.out.println("Logging: Connection request.");
        next.connect();
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Logging: Query execution - " + query);
        next.executeQuery(query);
    }
}
