package solidprinciples.interfacea.paymentgateway;


public class CreditCardProcessor implements CreditCardPayment {
    @Override
    public void processCreditCardPayment() {
        System.out.println("Processing credit card payment...");
    }
}