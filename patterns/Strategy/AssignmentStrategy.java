package patterns.Strategy;



import model.Volunteer;

import java.util.List;

public interface AssignmentStrategy {
    void assignTask(List<Volunteer> volunteers, String task);
}
