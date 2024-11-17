package controller;

import model.Volunteer;
import patterns.Singleton.*;
import patterns.Observer.*;

import java.io.IOException;
import java.util.List;

public class VolunteerController extends BaseController<Volunteer> {
    private final EventNotifier notifier;

    public VolunteerController() {
        super("data/volunteers.txt");
        notifier = EventNotifier.getInstance();
    }

    public void addVolunteer(Volunteer volunteer) throws IOException {
        create(volunteer, volunteer.toString());
        notifier.registerObserver(new VolunteerObserver(volunteer.getName()));
    }

    public List<Volunteer> getVolunteers() throws IOException {
        return readAll(Volunteer::fromString);
    }
    public void updateVolunteer(String oldName, Volunteer updatedVolunteer) throws IOException {
        update(oldName, updatedVolunteer, updatedVolunteer.toString(), Volunteer::fromString);
    }

    public void deleteVolunteer(String name) throws IOException {
        delete(name);
    }
}
