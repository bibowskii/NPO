package patterns.Strategy;


import model.Volunteer;

import java.util.List;
import java.util.Random;

public class RandomAssignment implements AssignmentStrategy {
    @Override
    public void assignTask(List<Volunteer> volunteers, String task) {
        Random random = new Random();
        Volunteer selected = volunteers.get(random.nextInt(volunteers.size()));
        System.out.println("Assigned " + task + " to volunteer: " + selected.getName());
    }
}
