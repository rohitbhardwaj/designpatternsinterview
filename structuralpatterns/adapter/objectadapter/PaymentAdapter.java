package structuralpatterns.adapter.objectadapter ;  
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


