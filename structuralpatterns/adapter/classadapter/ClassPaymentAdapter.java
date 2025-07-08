package structuralpatterns.adapter.classadapter;

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