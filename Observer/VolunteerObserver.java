package patterns.Observer;


public class VolunteerObserver implements EventObserver {
    private final String name;

    public VolunteerObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String eventDetails) {
        System.out.println("Notification for " + name + ": " + eventDetails);
    }
}
