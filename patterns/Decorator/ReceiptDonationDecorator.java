package patterns.Decorator;


import model.Donation;

public class ReceiptDonationDecorator extends DonationDecorator {
    public ReceiptDonationDecorator(Donation donation) {
        super(donation);
    }

    @Override
    public String generateReceipt() {
        return "Receipt\nDonor: " + decoratedDonation.getDonorName() +
                "\nAmount: " + decoratedDonation.getAmount() +
                "\nType: " + decoratedDonation.getDonationType();
    }
}
