package behavioralpatterns.observer;

/**
 * Subject interface for managing observers.
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
