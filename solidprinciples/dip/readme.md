### **Dependency Inversion Principle (DIP)**

#### **Concept**
The Dependency Inversion Principle (DIP) states:
1. High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces or abstract classes).
2. Abstractions should not depend on details; details should depend on abstractions.

This principle helps create loosely coupled systems where changes in one module do not heavily impact others.

---

### **Why It’s Important**
1. **Flexibility**: Code becomes modular and easier to extend.
2. **Testability**: Modules can be tested independently using mocks or stubs.
3. **Maintainability**: Changes in low-level modules don’t break high-level modules.

---

### **Violations of DIP**

#### **Practical Example**
**Problem**: A high-level module directly depends on a low-level module, creating tight coupling.

---

#### **Code Example: Violating DIP**

```java
/**
 * Low-level module responsible for sending emails.
 */
public class EmailSender {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

/**
 * High-level module responsible for user notifications.
 */
public class NotificationService {
    private EmailSender emailSender;

    public NotificationService() {
        this.emailSender = new EmailSender(); // Tight coupling to the low-level module
    }

    public void notifyUser(String message) {
        emailSender.sendEmail(message); // Direct dependency on low-level module
    }
}
```

#### **Why It Violates DIP**
1. **Direct Dependency**: The `NotificationService` depends directly on the concrete `EmailSender` class.
2. **Lack of Flexibility**: If you want to send SMS or push notifications instead of email, the `NotificationService` code must be modified.
3. **Testing Challenges**: Testing the `NotificationService` requires real instances of `EmailSender`.

---

### **Fixing the Violation**

#### **Refactored Design: Using Abstractions**

**Step 1: Define an Abstraction**
Create an interface for message sending:
```java
/**
 * Abstraction for sending messages.
 */
public interface MessageSender {
    void sendMessage(String message);
}
```

**Step 2: Implement the Interface**
Create implementations for email and SMS:
```java
/**
 * Low-level module for sending emails.
 */
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

/**
 * Low-level module for sending SMS.
 */
public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
```

**Step 3: Inject the Dependency**
Update the `NotificationService` to depend on the `MessageSender` abstraction:
```java
/**
 * High-level module depending on abstraction (MessageSender).
 */
public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender; // Dependency injection
    }

    public void notifyUser(String message) {
        messageSender.sendMessage(message); // Uses abstraction
    }
}
```

**Step 4: Testing and Usage**
```java
public class Main {
    public static void main(String[] args) {
        // Use EmailSender
        MessageSender emailSender = new EmailSender();
        NotificationService emailNotification = new NotificationService(emailSender);
        emailNotification.notifyUser("Hello via Email!");

        // Use SmsSender
        MessageSender smsSender = new SmsSender();
        NotificationService smsNotification = new NotificationService(smsSender);
        smsNotification.notifyUser("Hello via SMS!");
    }
}
```

---

### **Dependency Injection in Spring**

#### **Example: Using Spring Framework for Dependency Injection**

Spring provides built-in support for dependency injection via annotations and configuration.

---

**Step 1: Define the Abstraction**
```java
public interface MessageSender {
    void sendMessage(String message);
}
```

**Step 2: Implement the Interface**
```java
import org.springframework.stereotype.Component;

/**
 * EmailSender implementation using Spring's @Component annotation.
 */
@Component
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

/**
 * SmsSender implementation using Spring's @Component annotation.
 */
@Component
public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
```

**Step 3: Inject the Dependency**
Use `@Autowired` to inject the dependency:
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NotificationService depending on the abstraction.
 */
@Service
public class NotificationService {
    private final MessageSender messageSender;

    @Autowired
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender; // Spring automatically injects the dependency
    }

    public void notifyUser(String message) {
        messageSender.sendMessage(message);
    }
}
```

**Step 4: Spring Configuration and Application**
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotificationApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NotificationApp.class, args);

        // Get NotificationService bean
        NotificationService notificationService = context.getBean(NotificationService.class);

        // Send notification
        notificationService.notifyUser("Hello, user!");
    }
}
```

---

### **How Spring Selects the Implementation**
- If there are multiple `MessageSender` implementations (e.g., `EmailSender`, `SmsSender`), you can use `@Qualifier` to specify which bean to inject:
```java
@Autowired
@Qualifier("emailSender")
private MessageSender messageSender;
```

---

### **Benefits of Applying DIP with Spring**
1. **Loosely Coupled Code**:
   - High-level modules depend on abstractions, not concrete implementations.
2. **Improved Testability**:
   - Mocks or stubs can be injected for unit testing.
3. **Enhanced Flexibility**:
   - Adding new message-sending methods (e.g., push notifications) requires no changes to the `NotificationService`.

---

### **Key Takeaways**
- Use interfaces or abstract classes to decouple high-level and low-level modules.
- Prefer dependency injection to provide the required dependencies at runtime.
- Spring simplifies implementing DIP by automating dependency injection through annotations.