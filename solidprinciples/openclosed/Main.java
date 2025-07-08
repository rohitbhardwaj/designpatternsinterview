package solidprinciples.openclosed;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardProcessor.process();

        PaymentProcessor payPalProcessor = new PaymentProcessor(new PayPalPayment());
        payPalProcessor.process();

        PaymentProcessor googlePayProcessor = new PaymentProcessor(new GooglePayPayment());
        googlePayProcessor.process();
    }
}
