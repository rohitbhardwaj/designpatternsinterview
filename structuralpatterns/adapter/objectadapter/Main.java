package structuralpatterns.adapter.objectadapter ; 


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