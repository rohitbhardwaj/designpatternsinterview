package behavioralpatterns.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        paymentContext.processPayment(100.00);

        // Pay using PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentContext.processPayment(200.00);

        // Pay using Bitcoin
        paymentContext.setPaymentStrategy(new BitcoinPayment("1BitcoinAddress123"));
        paymentContext.processPayment(300.00);
    }
}