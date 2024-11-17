package controller;

import model.Event;
import patterns.Singleton.*;

import java.io.IOException;
import java.util.List;

public class EventController extends BaseController<Event> {
    private final EventNotifier notifier;

    public EventController() {
        super("data/events.txt");
        notifier = EventNotifier.getInstance();
    }

    public void addEvent(Event event) throws IOException {
        create(event, event.toString());
        notifier.notifyObservers("New Event Added: " + event.getName() + " on " + event.getDate());
    }

    public List<Event> getEvents() throws IOException {
        return readAll(Event::fromString);
    }
    public void updateEvent(String oldName, Event updatedEvent) throws IOException {
        update(oldName, updatedEvent, updatedEvent.toString(), Event::fromString);
    }

    public void deleteEvent(String name) throws IOException {
        delete(name);
    }
}
