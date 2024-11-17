package model;

public class Volunteer {
    private String name;
    private String skills;
    private int hours;

    public Volunteer(String name, String skills, int hours) {
        this.name = name;
        this.skills = skills;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getSkills() {
        return skills;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return name + "," + skills + "," + hours;
    }

    public static Volunteer fromString(String line) {
        String[] parts = line.split(",");
        return new Volunteer(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
