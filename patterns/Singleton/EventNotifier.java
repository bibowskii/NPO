package patterns.Singleton;

import java.util.ArrayList;
import java.util.List;

import patterns.Observer.EventObserver;

public class EventNotifier {
    private static EventNotifier instance;
    private final List<EventObserver> observers;

    private EventNotifier() {
        observers = new ArrayList<>();
    }

    public static EventNotifier getInstance() {
        if (instance == null) {
            instance = new EventNotifier();
        }
        return instance;
    }

    public void registerObserver(EventObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String eventDetails) {
        for (EventObserver observer : observers) {
            observer.update(eventDetails);
        }
    }
}
