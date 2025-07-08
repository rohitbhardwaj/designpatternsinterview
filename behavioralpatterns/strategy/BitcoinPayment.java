package behavioralpatterns.strategy;

/**
 * Concrete strategy for Bitcoin payments.
 */
public class BitcoinPayment implements PaymentStrategy {
    private final String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bitcoin Wallet: " + walletAddress);
    }
}