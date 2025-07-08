### **Structural Design Patterns: Proxy Pattern**

#### **Objective**
The **Proxy Design Pattern** acts as a surrogate or placeholder for another object, controlling access to it. This pattern is particularly useful for **lazy loading**, **access control**, **caching**, and **logging/monitoring** tasks. It provides a layer of control before the client interacts with the actual object.

---

### **Key Components**

1. **Subject**:
   - An interface or abstract class shared by the `RealSubject` and `Proxy`.
   - Declares methods that the client can call.

2. **RealSubject**:
   - The actual object that contains the core logic or business operation.
   - Implements the `Subject` interface.

3. **Proxy**:
   - A placeholder or surrogate for the `RealSubject`.
   - Implements the `Subject` interface.
   - Adds additional logic (e.g., access control, lazy loading, logging) before delegating the request to the `RealSubject`.

---

### **When to Use Proxy Pattern**

1. **Lazy Loading**:
   - Delay the creation of resource-intensive objects until they’re actually needed.

2. **Access Control**:
   - Enforce permissions or policies before allowing access to the `RealSubject`.

3. **Caching**:
   - Cache results or data to optimize repeated operations on the `RealSubject`.

4. **Logging/Monitoring**:
   - Track or log method calls without modifying the `RealSubject`.

5. **Remote Access**:
   - Represent objects located on different systems (Remote Proxy).

---

### **Implementation**

#### **Use Case**: 
A **Database Proxy** is used to control access to a database connection. The proxy provides **logging**, **lazy loading**, and **access control**.

---

#### **1. Subject Interface**

Define the common interface for the `RealSubject` and `Proxy`:

```java
/**
 * Subject interface defining the methods for database operations.
 */
public interface Database {
    void connect(); // Connect to the database
    void executeQuery(String query); // Execute a query
}
```

---

#### **2. RealSubject**

Implement the `Database` interface with the actual connection logic:

```java
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
```

---

#### **3. Proxy**

Implement the `Database` interface with additional logic for lazy loading, logging, and access control:

```java
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
```

---

#### **4. Client**

The client interacts with the `Proxy` instead of the `RealSubject`:

```java
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
```

---

### **Output**

```plaintext
Proxy: Logging connection request.
Connecting to the database...
Proxy: Logging query execution.
Executing query: SELECT * FROM users

Access denied: You do not have permission to connect.
Access denied: You do not have permission to execute queries.
```

---

### **Chaining Proxies**

Chaining proxies allows multiple proxies to handle different responsibilities before delegating to the `RealSubject`. For example, a **logging proxy** could chain with a **caching proxy**.

```java
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

public class CachingProxy implements Database {
    private final Database next;
    private final Map<String, String> cache = new HashMap<>();

    public CachingProxy(Database next) {
        this.next = next;
    }

    @Override
    public void connect() {
        next.connect();
    }

    @Override
    public void executeQuery(String query) {
        if (cache.containsKey(query)) {
            System.out.println("Cache hit: " + cache.get(query));
        } else {
            next.executeQuery(query);
            cache.put(query, "Result of " + query);
        }
    }
}
```

---

### **Benefits of Proxy Pattern**

1. **Lazy Initialization**:
   - Improves performance by delaying object creation until it’s needed.

2. **Access Control**:
   - Adds security checks or permission handling.

3. **Logging and Monitoring**:
   - Centralizes logging without modifying the `RealSubject`.

4. **Caching**:
   - Reduces redundant operations by caching results.

5. **Separation of Concerns**:
   - The proxy handles cross-cutting concerns (e.g., logging, caching), keeping the `RealSubject` focused on its core functionality.

---

### **Challenges**

1. **Performance Overhead**:
   - Proxies add an additional layer of abstraction, which can introduce overhead.

2. **Complexity**:
   - Chaining multiple proxies can make the design harder to debug.

3. **Coupling**:
   - Proxy and `RealSubject` are tightly coupled, as the proxy relies on the `RealSubject`.

---

### **When to Use Proxy Pattern**

1. **Lazy Loading**:
   - When creating an object is resource-intensive and should only be done when needed.

2. **Access Control**:
   - When certain clients require restricted or secure access.

3. **Caching**:
   - When repeated operations can benefit from caching previous results.

4. **Distributed Systems**:
   - When interacting with remote objects, proxies can handle communication details.

---

### **When Not to Use Proxy Pattern**

1. **Simple Objects**:
   - Avoid adding unnecessary complexity for lightweight objects.

2. **No Access Control**:
   - When there are no additional concerns like access control or logging.

3. **Direct Access**:
   - If direct interaction with the object is sufficient, a proxy adds unnecessary abstraction.

---

### **Key Takeaways**

- The **Proxy Pattern** adds control, optimization, and monitoring capabilities between the client and the real object.
- It’s highly useful for scenarios like lazy loading, access control, logging, and caching.
- While powerful, it can introduce complexity and performance overhead, so use it judiciously.