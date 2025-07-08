package behavioralpatterns.observer;

public class Main {
    public static void main(String[] args) {
        // Create the subject
        NewsAgency agency = new NewsAgency();

        // Create observers
        Observer subscriber1 = new NewsSubscriber("Alice");
        Observer subscriber2 = new NewsSubscriber("Bob");
        Observer subscriber3 = new NewsSubscriber("Charlie");

        // Add observers to the subject
        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);
        agency.addObserver(subscriber3);

        // Publish news and notify observers
        agency.setNews("Breaking News: Observer Pattern Implemented!");
        agency.setNews("Latest Update: Pattern Examples Delivered!");
    }
}