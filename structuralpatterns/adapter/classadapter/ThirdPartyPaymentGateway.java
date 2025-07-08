package structuralpatterns.adapter.classadapter;

public class ThirdPartyPaymentGateway {
    public void makePayment(String currency, double amount) {
        System.out.println("Processing payment of " + amount + " " + currency + " through ThirdPartyPaymentGateway.");
    }
}