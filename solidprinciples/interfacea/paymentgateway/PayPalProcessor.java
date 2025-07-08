package solidprinciples.interfacea.paymentgateway;

public class PayPalProcessor implements PayPalPayment {
    @Override
    public void processPayPalPayment() {
        System.out.println("Processing PayPal payment...");
    }
}