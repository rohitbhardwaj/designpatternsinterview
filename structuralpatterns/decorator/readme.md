### **Structural Design Patterns: Decorator Pattern**

#### **Objective**
The **Decorator Design Pattern** enhances the functionality of individual objects dynamically without modifying their code or affecting other objects. It is particularly useful when you need to add or combine behaviors at runtime while adhering to the **Open/Closed Principle**.

---

### **What is the Decorator Pattern?**

The **Decorator Pattern** is a structural design pattern that allows you to dynamically extend the behavior of objects. It involves wrapping objects with decorator classes that add new functionality without altering the object's original implementation.

---

### **Key Characteristics**
1. **Dynamic Behavior**:  
   - Add functionalities to objects at runtime.

2. **Open/Closed Principle**:  
   - New decorators can be introduced without modifying existing code.

3. **Composition Over Inheritance**:  
   - Promotes reuse by avoiding the need to create multiple subclasses for different combinations of behaviors.

---

### **Real-World Analogy**
**Adding Toppings to Ice Cream**:  
- The base ice cream represents the core object.  
- Toppings like chocolate, nuts, and sprinkles are decorators that add new features to the ice cream dynamically.

---

### **Implementation**

#### **Use Case**:  
Enhancing UI components dynamically by adding features like borders, shadows, or scrollbars to a `TextView`.

---

#### **1. Component Interface**
Define the base interface for UI components:

```java
/**
 * Component interface for UI elements.
 */
public interface UIComponent {
    void render(); // Method to render the UI component
}
```

---

#### **2. Concrete Component**
Create a concrete implementation of the `UIComponent`:

```java
/**
 * Concrete Component representing a basic TextView.
 */
public class TextView implements UIComponent {
    @Override
    public void render() {
        System.out.println("Rendering TextView.");
    }
}
```

---

#### **3. Base Decorator**
Create an abstract decorator that implements the `UIComponent` interface and contains a reference to the wrapped component:

```java
/**
 * Abstract Decorator implementing the UIComponent interface.
 */
public abstract class ComponentDecorator implements UIComponent {
    protected final UIComponent component;

    public ComponentDecorator(UIComponent component) {
        this.component = component;
    }

    @Override
    public void render() {
        component.render(); // Delegate rendering to the wrapped component
    }
}
```

---

#### **4. Concrete Decorators**
Implement specific decorators to add new functionalities:

**Border Decorator**:
```java
/**
 * Concrete Decorator to add a border to the UI component.
 */
public class BorderDecorator extends ComponentDecorator {
    public BorderDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render(); // Render the base component
        addBorder();    // Add border functionality
    }

    private void addBorder() {
        System.out.println("Adding border to the component.");
    }
}
```

**Shadow Decorator**:
```java
/**
 * Concrete Decorator to add a shadow to the UI component.
 */
public class ShadowDecorator extends ComponentDecorator {
    public ShadowDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        super.render(); // Render the base component
        addShadow();    // Add shadow functionality
    }

    private void addShadow() {
        System.out.println("Adding shadow to the component.");
    }
}
```

---

#### **5. Client**
The client dynamically decorates the `TextView` with various features:

```java
public class Main {
    public static void main(String[] args) {
        // Create a basic TextView
        UIComponent textView = new TextView();

        // Decorate the TextView with a border
        UIComponent borderedTextView = new BorderDecorator(textView);

        // Decorate the bordered TextView with a shadow
        UIComponent borderedShadowedTextView = new ShadowDecorator(borderedTextView);

        // Render the components
        System.out.println("Rendering basic TextView:");
        textView.render();

        System.out.println("\nRendering TextView with Border:");
        borderedTextView.render();

        System.out.println("\nRendering TextView with Border and Shadow:");
        borderedShadowedTextView.render();
    }
}
```

---

### **Output**

```plaintext
Rendering basic TextView:
Rendering TextView.

Rendering TextView with Border:
Rendering TextView.
Adding border to the component.

Rendering TextView with Border and Shadow:
Rendering TextView.
Adding border to the component.
Adding shadow to the component.
```

---

### **Benefits of Decorator Pattern**

1. **Flexibility**:  
   - Dynamically add or remove functionalities at runtime without modifying the original object.

2. **Open/Closed Principle**:  
   - Existing components are not modified; new decorators can be added independently.

3. **Combining Behaviors**:  
   - Multiple decorators can be stacked to combine features.

4. **Avoids Subclass Explosion**:  
   - Eliminates the need for creating multiple subclasses for every possible combination of behaviors.

---

### **Challenges**

1. **Complexity**:  
   - Decorator chains can become difficult to debug due to layered wrapping.

2. **Overhead**:  
   - Multiple decorators increase the number of objects in memory.

---

### **When to Use Decorator Pattern**

1. **Dynamic Behavior Addition**:  
   - When you need to add functionality to objects at runtime.  

2. **Avoid Inheritance**:  
   - When subclassing leads to too many combinations of classes.  

3. **Reusable Features**:  
   - When you need features that can be reused across different objects.  

---

### **Real-World Examples**

1. **Graphical User Interfaces (GUIs)**:  
   - Adding scrollbars, borders, or shadows to components dynamically.  

2. **Text Formatting**:  
   - Applying bold, italic, or underline styles to text dynamically.  

3. **Data Streams**:  
   - Wrapping input/output streams with functionalities like buffering or encryption (e.g., Java’s `BufferedInputStream`).

---

### **Key Takeaways**

- The **Decorator Pattern** is ideal for enhancing object functionality dynamically.
- It promotes modularity, reusability, and flexibility by composing behaviors at runtime.
- While powerful, it can lead to complexity when dealing with extensive decorator chains.