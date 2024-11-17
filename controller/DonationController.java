package controller;

import model.Donation;
import patterns.Decorator.*;


import java.io.IOException;
import java.util.List;

public class DonationController extends BaseController<Donation> {
    public DonationController() {
        super("data/donors.txt");
    }

    public void addDonation(Donation donation) throws IOException {
        DonationDecorator decoratedDonation = new ReceiptDonationDecorator(donation);
        System.out.println(decoratedDonation.generateReceipt());
        create(donation, donation.toString());
    }

    public List<Donation> getDonations() throws IOException {
        return readAll(Donation::fromString);
    }
    public void updateDonation(String donorName, Donation updatedDonation) throws IOException {
        update(donorName, updatedDonation, updatedDonation.toString(), Donation::fromString);
    }
    public void deleteDonation(String donorName) throws IOException {
        delete(donorName);
    }
        
}
