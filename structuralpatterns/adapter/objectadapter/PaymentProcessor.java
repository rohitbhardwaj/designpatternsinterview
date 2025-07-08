package structuralpatterns.adapter.objectadapter ; 

/**
 * The interface expected by the client.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}
