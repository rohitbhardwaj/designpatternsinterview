package structuralpatterns.proxy;

public class Main {
    public static void main(String[] args) {
        // Create a proxy with access
        Database databaseWithAccess = new DatabaseProxy(true);
        databaseWithAccess.connect();
        databaseWithAccess.executeQuery("SELECT * FROM users");

        System.out.println();

        // Create a proxy without access
        Database databaseWithoutAccess = new DatabaseProxy(false);
        databaseWithoutAccess.connect();
        databaseWithoutAccess.executeQuery("DELETE FROM users");
    }
}