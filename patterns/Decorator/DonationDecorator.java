package patterns.Decorator;


import model.Donation;

public abstract class DonationDecorator extends Donation {
    protected final Donation decoratedDonation;

    public DonationDecorator(Donation donation) {
        super(donation.getDonorName(), donation.getAmount(), donation.getDonationType());
        this.decoratedDonation = donation;
    }

    public abstract String generateReceipt();
}

