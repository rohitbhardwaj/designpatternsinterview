package structuralpatterns.adapter.classadapter;

public class Main {
    public static void main(String[] args) {
        // Use the class adapter
        PaymentProcessor adapter = new ClassPaymentAdapter();

        // Process a payment
        adapter.processPayment(150.00);
    }
}