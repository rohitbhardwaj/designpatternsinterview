package solidprinciples.openclosed;

public class PaymentProcessorNew {
    private final PaymentMethod paymentMethod;

    public PaymentProcessorNew(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process() {
        paymentMethod.processPayment();
    }


    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardProcessor.process();

        PaymentProcessor payPalProcessor = new PaymentProcessor(new PayPalPayment());
        payPalProcessor.process();

        PaymentProcessor googlePayProcessor = new PaymentProcessor(new GooglePayPayment());
        googlePayProcessor.process();
    }
}
