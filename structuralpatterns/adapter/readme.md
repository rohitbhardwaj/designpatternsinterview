### **Structural Design Patterns: Adapter Pattern**

#### **Objective**
The **Adapter Design Pattern** is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.

---

### **Real-World Analogy**
**Electrical Plug Adapters**:  
Imagine you have a device with a US plug but only European sockets are available. A plug adapter allows the US plug to fit into the European socket, enabling compatibility between the two systems.

---

### **Types of Adapter Patterns**

1. **Object Adapter**:  
   - Uses composition to adapt the functionality of one object to another.
   
2. **Class Adapter**:  
   - Uses inheritance to adapt one interface to another.

---

### **Implementation**

#### **Use Case**
A payment processing system has a new third-party payment gateway, but its API is incompatible with the existing system. We’ll use an adapter to bridge the gap.

---

#### **1. Object Adapter**

**Step 1: Target Interface**
Define the interface expected by the client:

```java
/**
 * The interface expected by the client.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}
```

---

**Step 2: Adaptee**
This is the third-party payment gateway with an incompatible interface:

```java
/**
 * Third-party payment gateway with an incompatible API.
 */
public class ThirdPartyPaymentGateway {
    public void makePayment(String currency, double amount) {
        System.out.println("Processing payment of " + amount + " " + currency + " through ThirdPartyPaymentGateway.");
    }
}
```

---

**Step 3: Adapter**
The adapter bridges the gap between the `PaymentProcessor` interface and `ThirdPartyPaymentGateway`:

```java
/**
 * Adapter that bridges the PaymentProcessor interface and ThirdPartyPaymentGateway.
 */
public class PaymentAdapter implements PaymentProcessor {
    private final ThirdPartyPaymentGateway gateway;

    public PaymentAdapter(ThirdPartyPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        // Adapting the method call
        gateway.makePayment("USD", amount);
    }
}
```

---

**Step 4: Client**
The client interacts with the `PaymentProcessor` interface and remains unaware of the third-party API:

```java
public class Main {
    public static void main(String[] args) {
        // Create the third-party gateway
        ThirdPartyPaymentGateway thirdPartyGateway = new ThirdPartyPaymentGateway();

        // Create the adapter
        PaymentProcessor adapter = new PaymentAdapter(thirdPartyGateway);

        // Use the adapter to process a payment
        adapter.processPayment(100.00);
    }
}
```

---

#### **Output**

```plaintext
Processing payment of 100.0 USD through ThirdPartyPaymentGateway.
```

---

#### **2. Class Adapter**

**Step 1: Target Interface**
Same as the object adapter example.

```java
public interface PaymentProcessor {
    void processPayment(double amount);
}
```

---

**Step 2: Adaptee**
Same as the object adapter example.

```java
public class ThirdPartyPaymentGateway {
    public void makePayment(String currency, double amount) {
        System.out.println("Processing payment of " + amount + " " + currency + " through ThirdPartyPaymentGateway.");
    }
}
```

---

**Step 3: Adapter**
The class adapter uses inheritance to adapt the `ThirdPartyPaymentGateway`:

```java
/**
 * Class Adapter that extends ThirdPartyPaymentGateway and implements PaymentProcessor.
 */
public class ClassPaymentAdapter extends ThirdPartyPaymentGateway implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        // Adapting the method call
        makePayment("USD", amount);
    }
}
```

---

**Step 4: Client**
Same as the object adapter example:

```java
public class Main {
    public static void main(String[] args) {
        // Use the class adapter
        PaymentProcessor adapter = new ClassPaymentAdapter();

        // Process a payment
        adapter.processPayment(150.00);
    }
}
```

---

#### **Output**

```plaintext
Processing payment of 150.0 USD through ThirdPartyPaymentGateway.
```

---

### **Key Differences Between Object and Class Adapter**

| **Aspect**               | **Object Adapter**                                 | **Class Adapter**                                  |
|---------------------------|---------------------------------------------------|---------------------------------------------------|
| **Implementation**        | Uses composition (contains an instance of Adaptee)| Uses inheritance (extends Adaptee).              |
| **Flexibility**           | Can work with multiple Adaptee classes.           | Limited to one Adaptee class due to single inheritance. |
| **Reusability**           | High, as it doesn’t rely on inheritance.          | Less, as it depends on inheritance hierarchy.     |

---

### **Benefits of Adapter Pattern**

1. **Interoperability**:  
   - Allows incompatible systems to work together seamlessly.

2. **Reusability**:  
   - Enables reuse of existing functionality by adapting it to new interfaces.

3. **Flexibility**:  
   - Can adapt multiple implementations without modifying the original Adaptee.

---

### **Challenges**

1. **Increased Complexity**:  
   - Introduces additional layers of abstraction, which can make the design harder to understand.

2. **Dependency on Adaptee**:  
   - Requires knowledge of the Adaptee’s API, which might change over time.

---

### **When to Use Adapter Pattern**

1. **Legacy Code Integration**:  
   - When integrating new functionality with existing systems that have incompatible interfaces.

2. **Third-Party Libraries**:  
   - When working with third-party libraries that expose APIs incompatible with your system.

3. **Cross-Platform Development**:  
   - When bridging differences between platform-specific APIs.

---

### **Real-World Examples**

1. **Electrical Plug Adapters**:  
   - Allow devices with US plugs to connect to European sockets.

2. **Media Players**:  
   - Adapting different media formats (e.g., MP3, MP4) to a unified player interface.

3. **Database Drivers**:  
   - Allow applications to use a common database interface (e.g., JDBC) regardless of the database vendor.

---

### **Key Takeaways**

- The **Adapter Pattern** is a powerful tool for integrating incompatible systems.
- Use **Object Adapter** for greater flexibility and **Class Adapter** for simpler use cases with single inheritance.
- This pattern promotes reuse, flexibility, and seamless integration between systems with different APIs. 