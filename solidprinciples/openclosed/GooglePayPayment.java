package solidprinciples.openclosed;

public class GooglePayPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing Google Pay payment...");
    }


 
}