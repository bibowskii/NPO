package model;

public class Donation {
    private String donorName;
    private double amount;
    private String donationType;

    public Donation(String donorName, double amount, String donationType) {
        this.donorName = donorName;
        this.amount = amount;
        this.donationType = donationType;
    }

    public String getDonorName() {
        return donorName;
    }

    public double getAmount() {
        return amount;
    }

    public String getDonationType() {
        return donationType;
    }

    @Override
    public String toString() {
        return donorName + "," + amount + "," + donationType;
    }

    public static Donation fromString(String line) {
        String[] parts = line.split(",");
        return new Donation(parts[0], Double.parseDouble(parts[1]), parts[2]);
    }
}
