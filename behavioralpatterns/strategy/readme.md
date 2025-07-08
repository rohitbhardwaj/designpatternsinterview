Behavioral Design Patterns: Strategy Pattern
Objective
The Strategy Design Pattern encapsulates a family of algorithms into separate classes and makes them interchangeable at runtime. It enables dynamic behavior selection without altering the code structure, promoting flexibility, modularity, and testability.

What is the Strategy Pattern?
The Strategy Pattern allows objects to select behavior dynamically at runtime by delegating functionality to interchangeable strategy objects. It provides a mechanism to define a family of algorithms, encapsulate each one, and switch between them without modifying the context or client code.

Key Components
Context:

Holds a reference to a strategy object.
Delegates the execution of behavior to the strategy object.
Strategy Interface:

Defines the common interface for all strategies, ensuring they can be used interchangeably.
Concrete Strategies:

Implement the strategy interface with specific algorithms or behaviors.
Client:

Configures the context with a specific strategy based on the requirements.
When to Use the Strategy Pattern
Multiple Algorithms:

When you have several interchangeable algorithms or behaviors.
Runtime Selection:

When the behavior needs to be selected or switched dynamically during runtime.
Reduce Conditional Logic:

To eliminate complex if-else or switch statements for behavior selection.
Encapsulated Algorithms:

To encapsulate algorithms for easier maintenance, testing, and modification.
Extensibility:

When you anticipate adding new behaviors or algorithms in the future.
When Not to Use the Strategy Pattern
Single Algorithm:

If only one behavior is needed, introducing multiple strategies adds unnecessary complexity.
Overhead:

For simple scenarios, creating multiple strategy classes and maintaining them may not be worth the effort.
Inflexible Context:

If the context depends tightly on a single algorithm, the Strategy Pattern may introduce unnecessary abstraction.
Implementation
Use Case:
A payment system where different payment gateways (e.g., Credit Card, PayPal, and Bitcoin) are implemented as interchangeable strategies.

1. Strategy Interface
Define the interface for all payment strategies:

java
Copy code
/**
 * Strategy interface for payment methods.
 */
public interface PaymentStrategy {
    void pay(double amount);
}
2. Concrete Strategies
Implement specific payment methods:

Credit Card Payment:

java
Copy code
/**
 * Concrete strategy for credit card payments.
 */
public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}
PayPal Payment:

java
Copy code
/**
 * Concrete strategy for PayPal payments.
 */
public class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}
Bitcoin Payment:

java
Copy code
/**
 * Concrete strategy for Bitcoin payments.
 */
public class BitcoinPayment implements PaymentStrategy {
    private final String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bitcoin Wallet: " + walletAddress);
    }
}
3. Context
The context manages the current payment strategy and delegates payment tasks:

java
Copy code
/**
 * Context class for processing payments.
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
}
4. Client
The client selects the strategy and processes payments:

java
Copy code
public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        paymentContext.processPayment(100.00);

        // Pay using PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentContext.processPayment(200.00);

        // Pay using Bitcoin
        paymentContext.setPaymentStrategy(new BitcoinPayment("1BitcoinAddress123"));
        paymentContext.processPayment(300.00);
    }
}
Output
plaintext
Copy code
Paid $100.0 using Credit Card: 1234-5678-9876-5432
Paid $200.0 using PayPal: user@example.com
Paid $300.0 using Bitcoin Wallet: 1BitcoinAddress123
Benefits of the Strategy Pattern
Encapsulation of Algorithms:

Separates algorithms into individual classes, making them easier to understand and maintain.
Dynamic Behavior Switching:

Allows changing behavior at runtime by swapping strategies.
Extensibility:

New strategies can be added without modifying the context or client code.
Testability:

Each strategy can be tested independently.
Eliminates Conditional Logic:

Reduces the need for complex if-else or switch statements.
Challenges
Increased Class Count:

Requires creating separate classes for each strategy.
Client Awareness:

The client must know which strategy to select and when.
Overhead for Simple Problems:

May introduce unnecessary complexity for simple scenarios.
Real-World Applications
Payment Systems:

Handle multiple payment methods like credit cards, PayPal, or digital wallets.
Sorting Algorithms:

Switch between different sorting techniques like Bubble Sort, Quick Sort, etc.
Compression Tools:

Dynamically select algorithms like ZIP, RAR, or TAR based on user preference.
Game AI:

Switch between strategies for different game levels or opponents.
Authentication Systems:

Dynamically select authentication methods (e.g., OAuth, Basic Auth, Token-based).
Key Takeaways
The Strategy Pattern is ideal for dynamic algorithm selection and behavior switching.
It promotes flexibility, modularity, and scalability but should be applied judiciously to avoid over-engineering.
Use it when multiple interchangeable algorithms are required, and the selection depends on runtime conditions.