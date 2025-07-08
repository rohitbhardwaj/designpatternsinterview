### **Single Responsibility Principle (SRP)**

#### **Concept**
The Single Responsibility Principle (SRP) states that a class should have only one reason to change. In simpler terms, a class should only perform one specific responsibility or function. This principle helps make code easier to understand, test, and maintain.

#### **Key Benefits**
1. **Improved Maintainability**: Changes to one responsibility do not affect unrelated functionality.
2. **Easier Testing**: Smaller classes with a single responsibility are easier to test.
3. **Reduced Coupling**: By separating concerns, classes are less dependent on one another.

---

### **Examples**

#### **Example 1: Before Applying SRP**  
**Problem**: A class that handles multiple responsibilities.  
```java
public class EmployeeManager {
    public void calculateSalary(Employee employee) {
        // Logic to calculate salary
    }

    public void saveToDatabase(Employee employee) {
        // Logic to save employee data to database
    }

    public void generateReport(Employee employee) {
        // Logic to generate report
    }
}
```

**Why it violates SRP**:  
- The `EmployeeManager` class has multiple reasons to change:
  1. If salary calculation changes.
  2. If database operations change.
  3. If report generation logic changes.

#### **Example 1: After Applying SRP**  
**Solution**: Separate the responsibilities into different classes.  
```java
public class SalaryCalculator {
    public void calculateSalary(Employee employee) {
        // Logic to calculate salary
    }
}

public class EmployeeRepository {
    public void saveToDatabase(Employee employee) {
        // Logic to save employee data to database
    }
}

public class ReportGenerator {
    public void generateReport(Employee employee) {
        // Logic to generate report
    }
}
```

**Result**:  
- Each class has a single responsibility, making it easier to maintain and test.  

---

#### **Common Violations of SRP**
1. **Multifunctional Classes**: Classes that mix responsibilities like database operations, business logic, and UI formatting.  
2. **Long Methods**: A single method that performs multiple tasks, making it hard to maintain and debug.  
3. **Hard-Coded Dependencies**: Classes directly depending on specific implementations instead of abstractions.

---

### **Refactoring Approaches**

#### **Approach 1: Extract Class**
Move related responsibilities into a new class.  
- **Before Refactoring**:  
```java
public class OrderProcessor {
    public void processOrder(Order order) {
        // Validate order
        // Save order to database
        // Notify customer
    }
}
```
- **After Refactoring**:  
```java
public class OrderValidator {
    public void validate(Order order) {
        // Validation logic
    }
}

public class OrderRepository {
    public void save(Order order) {
        // Database logic
    }
}

public class CustomerNotifier {
    public void notify(Order order) {
        // Notification logic
    }
}
```

#### **Approach 2: Use Dependency Injection**
Decouple responsibilities using interfaces and inject dependencies.  
- **Example**:  
```java
public class OrderProcessor {
    private final OrderValidator validator;
    private final OrderRepository repository;
    private final CustomerNotifier notifier;

    public OrderProcessor(OrderValidator validator, OrderRepository repository, CustomerNotifier notifier) {
        this.validator = validator;
        this.repository = repository;
        this.notifier = notifier;
    }

    public void processOrder(Order order) {
        validator.validate(order);
        repository.save(order);
        notifier.notify(order);
    }
}
```

#### **Approach 3: Modularize Large Methods**
Break down long methods into smaller, focused methods.  
- **Before Refactoring**:  
```java
public void generateInvoice(Order order) {
    // Calculate totals
    // Apply discounts
    // Format invoice
    // Save invoice to database
}
```
- **After Refactoring**:  
```java
public void generateInvoice(Order order) {
    double total = calculateTotals(order);
    double discountedTotal = applyDiscounts(total);
    String formattedInvoice = formatInvoice(order, discountedTotal);
    saveInvoiceToDatabase(formattedInvoice);
}
```

---

By following SRP, developers can build more robust, maintainable, and scalable applications.

Here's an example of an `Employee` class that can be used in the context of the Single Responsibility Principle examples:

```java
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Optional toString method for debugging
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
```

### **Explanation**
1. **Fields**:  
   - `id`: A unique identifier for the employee.  
   - `name`: The employee's name.  
   - `department`: The department in which the employee works.  
   - `salary`: The salary of the employee.

2. **Constructor**:  
   - Initializes the fields when creating an instance of `Employee`.

3. **Getters and Setters**:  
   - Allow controlled access to the fields.

4. **toString()**:  
   - Provides a string representation of the `Employee` object, useful for debugging or logging.

This class adheres to the Single Responsibility Principle by focusing solely on representing an employee entity and providing access to its data. It delegates all other responsibilities (e.g., saving to the database, generating reports) to other classes.

Here is an example of an `Order` class that can be used in various examples, including implementing the Single Responsibility Principle:

```java
import java.util.List;
import java.time.LocalDate;

public class Order {
    private int orderId;
    private LocalDate orderDate;
    private String customerName;
    private List<OrderItem> items;
    private String status; // e.g., "Pending", "Shipped", "Delivered"
    private double totalAmount;

    // Constructor
    public Order(int orderId, LocalDate orderDate, String customerName, List<OrderItem> items, String status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.items = items;
        this.status = status;
        this.totalAmount = calculateTotalAmount();
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
        this.totalAmount = calculateTotalAmount(); // Recalculate total when items change
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Calculate the total amount of the order
    private double calculateTotalAmount() {
        return items.stream()
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
    }

    // Optional toString method for debugging
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
```

### **Explanation**
1. **Fields**:
   - `orderId`: Unique identifier for the order.
   - `orderDate`: The date the order was placed.
   - `customerName`: The name of the customer placing the order.
   - `items`: A list of `OrderItem` objects representing the products in the order.
   - `status`: The current status of the order (e.g., "Pending").
   - `totalAmount`: The total price for all items in the order.

2. **Methods**:
   - `calculateTotalAmount()`: Computes the total cost of all items in the order.
   - Getters and setters to access and update the fields.

3. **toString()**:
   - Provides a human-readable format of the `Order` object, helpful for debugging or logging.

---

### **OrderItem Class**
You would also need an `OrderItem` class to represent individual items in the order:

```java
public class OrderItem {
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    public OrderItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Optional toString method for debugging
    @Override
    public String toString() {
        return "OrderItem{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
```

### **How They Work Together**
- An `Order` contains a list of `OrderItem` objects, which represent the individual items purchased.
- The `calculateTotalAmount` method in `Order` computes the total cost based on the price and quantity of each `OrderItem`.

This design adheres to SRP, as:
- The `Order` class focuses on managing order-level details.
- The `OrderItem` class focuses on representing individual item details.

