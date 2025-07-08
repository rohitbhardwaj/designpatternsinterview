package solidprinciples.openclosed;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    } 
}
