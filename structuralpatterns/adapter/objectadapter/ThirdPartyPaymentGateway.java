package structuralpatterns.adapter.objectadapter ; 


/**
 * Third-party payment gateway with an incompatible API.
 */
public class ThirdPartyPaymentGateway {
    public void makePayment(String currency, double amount) {
        System.out.println("Processing payment of " + amount + " " + currency + " through ThirdPartyPaymentGateway.");
    }
}
