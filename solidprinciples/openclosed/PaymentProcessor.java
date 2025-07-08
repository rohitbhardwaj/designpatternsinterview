package solidprinciples.openclosed;
/*
Scenario
You’re building a system to process payments. Initially, the system supports only credit card payments. Later, new payment methods (e.g., PayPal, Google Pay) need to be added without modifying the existing code.
*/

public class PaymentProcessor {


    public PaymentProcessor(PaymentMethod payment) {
        //TODO Auto-generated constructor stub
    }

    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing credit card payment...");
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Processing PayPal payment...");
        } else {
            System.out.println("Unsupported payment method.");
        }
    }

    public void process() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }
}

/*
 * Issues:
 * Each new payment type requires modifying the processPayment method.
 * The PaymentProcessor class grows in complexity, violating OCP.
 */