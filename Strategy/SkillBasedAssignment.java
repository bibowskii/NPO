package patterns.Strategy;


import model.Volunteer;

import java.util.List;

public class SkillBasedAssignment implements AssignmentStrategy {
    private final String requiredSkill;

    public SkillBasedAssignment(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    @Override
    public void assignTask(List<Volunteer> volunteers, String task) {
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getSkills().contains(requiredSkill)) {
                System.out.println("Assigned " + task + " to volunteer: " + volunteer.getName());
            }
        }
    }
}

