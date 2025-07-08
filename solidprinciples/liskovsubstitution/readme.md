### **Liskov Substitution Principle (LSP)**

#### **Concept**
The Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of its subclass without altering the correctness of the program. This means that a subclass should extend the functionality of the parent class without changing its behavior.

#### **Key Ideas**
1. **Behavioral Consistency**: Subtypes must not violate the expectations set by their base types.
2. **No Broken Contracts**: Subclasses must honor the contract (method signatures and behavior) defined by the parent class.
3. **Substitutability**: Wherever a base class object is expected, its derived class should work seamlessly.

---

### **Violations of LSP**

#### **Practical Example**
**Problem**: A violation of LSP can occur when a subclass overrides a method in a way that changes its expected behavior. Let’s consider an example:

---

#### **Code Example: Violating LSP**

```java
/**
 * Base class representing a geometric shape.
 */
public class Shape {
    /**
     * Calculates the area of the shape.
     * 
     * @return the area of the shape as a double.
     */
    public double getArea() {
        return 0.0; // Default implementation, meant to be overridden
    }
}

/**
 * Rectangle class extending Shape.
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height; // Area of a rectangle
    }

    // Getters and setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

/**
 * Square class extending Rectangle, introducing an LSP violation.
 */
public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width); // Ensure width and height are the same
    }

    @Override
    public void setHeight(double height) {
        super.setWidth(height);
        super.setHeight(height); // Ensure width and height are the same
    }
}
```

#### **Why It Violates LSP**
1. **Behavioral Change**:
   - `Square` changes the behavior of `setWidth` and `setHeight` in `Rectangle`.  
   - When `setWidth` or `setHeight` is called on a `Square`, it modifies both dimensions to ensure it remains a square, which violates the expected behavior of a rectangle.

2. **Substitutability Issue**:
   - If a `Square` object is used in place of a `Rectangle`, the behavior is inconsistent with the base class’s contract.

---

#### **Testing the Violation**
```java
public class Main {
    public static void main(String[] args) {
        // Using a rectangle
        Rectangle rectangle = new Rectangle(5, 10);
        rectangle.setWidth(7); // Expected: Changes only the width
        System.out.println("Rectangle Area: " + rectangle.getArea()); // Correct: 7 * 10 = 70

        // Using a square in place of a rectangle
        Rectangle square = new Square(5);
        square.setWidth(7); // Changes both width and height
        System.out.println("Square Area: " + square.getArea()); // Incorrect: Should be 7 * 5 = 35, but changes to 7 * 7
    }
}
```

---

### **Fixing the Violation**
To fix the violation, we can avoid inheritance where it doesn’t make sense and use composition instead.

---

#### **Refactored Design: Composition**
```java
/**
 * Base class representing a geometric shape.
 */
public abstract class Shape {
    /**
     * Abstract method to calculate the area of the shape.
     * 
     * @return the area of the shape as a double.
     */
    public abstract double getArea();
}

/**
 * Rectangle class implementing Shape.
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    // Getters and setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

/**
 * Square class using composition instead of inheritance.
 */
public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side; // Area of a square
    }

    // Getters and setters
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
```

---

#### **Testing the Fixed Code**
```java
public class Main {
    public static void main(String[] args) {
        // Using a rectangle
        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // 50

        // Using a square
        Shape square = new Square(5);
        System.out.println("Square Area: " + square.getArea()); // 25
    }
}
```

---

### **Benefits of Fixing the Violation**
1. **Behavioral Consistency**:
   - `Rectangle` and `Square` are now independent and adhere to their specific behaviors without interfering.

2. **Substitutability Restored**:
   - Each class can be substituted wherever `Shape` is expected without issues.

3. **Better Design**:
   - Avoids incorrect use of inheritance, ensuring a clean and maintainable design.

---

### **Key Takeaways**
- Use **composition over inheritance** when a subclass cannot strictly adhere to the behavior of the parent class.
- Always test if your subclasses can seamlessly replace their parent class objects in all contexts.
- LSP violations often signal that the relationship between base and derived classes is misinterpreted.