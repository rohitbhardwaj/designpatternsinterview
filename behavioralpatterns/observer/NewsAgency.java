package behavioralpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject implementation for a news agency.
 */
public class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers(); // Notify all observers when news changes
    }

    public String getNews() {
        return news;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}
