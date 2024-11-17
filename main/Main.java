

package main;

import controller.*;
import model.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        DonationController donationController = new DonationController();
        VolunteerController volunteerController = new VolunteerController();
        EventController eventController = new EventController();

        while (true) {
            System.out.println("\n=== Non-Profit Management System ===");
            System.out.println("1. Manage Donations");
            System.out.println("2. Manage Volunteers");
            System.out.println("3. Manage Events");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageDonations(donationController, scanner);
                    break;
                case 2:
                    manageVolunteers(volunteerController, scanner);
                    break;
                case 3:
                    manageEvents(eventController, scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void manageDonations(DonationController controller, Scanner scanner) throws IOException {
        System.out.println("\n1. Add Donation\n2. View Donations\n3. Update Donation\n4. Delete Donation");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Donor Name: ");
                String donor = scanner.nextLine();
                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Donation Type: ");
                String type = scanner.nextLine();
                controller.addDonation(new Donation(donor, amount, type));
                break;
            case 2:
                List<Donation> donations = controller.getDonations();
                donations.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Donor Name to Update: ");
                String donorName = scanner.nextLine();
                System.out.print("New Donor Name: ");
                String newDonor = scanner.nextLine();
                System.out.print("New Amount: ");
                double newAmount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("New Donation Type: ");
                String newType = scanner.nextLine();
                controller.updateDonation(donorName, new Donation(newDonor, newAmount, newType));
                break;
            case 4:
                System.out.print("Donor Name to Delete: ");
                String deleteName = scanner.nextLine();
                controller.deleteDonation(deleteName);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageVolunteers(VolunteerController controller, Scanner scanner) throws IOException {
        System.out.println("\n1. Add Volunteer\n2. View Volunteers\n3. Update Volunteer\n4. Delete Volunteer");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Volunteer Name: ");
                String name = scanner.nextLine();
                System.out.print("Skills: ");
                String skills = scanner.nextLine();
                System.out.print("Hours: ");
                int hours = scanner.nextInt();
                scanner.nextLine();
                controller.addVolunteer(new Volunteer(name, skills, hours));
                break;
            case 2:
                List<Volunteer> volunteers = controller.getVolunteers();
                volunteers.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Volunteer Name to Update: ");
                String oldName = scanner.nextLine();
                System.out.print("New Volunteer Name: ");
                String newName = scanner.nextLine();
                System.out.print("New Skills: ");
                String newSkills = scanner.nextLine();
                System.out.print("New Hours: ");
                int newHours = scanner.nextInt();
                scanner.nextLine();
                controller.updateVolunteer(oldName, new Volunteer(newName, newSkills, newHours));
                break;
            case 4:
                System.out.print("Volunteer Name to Delete: ");
                String deleteName = scanner.nextLine();
                controller.deleteVolunteer(deleteName);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageEvents(EventController controller, Scanner scanner) throws IOException {
        System.out.println("\n1. Add Event\n2. View Events\n3. Update Event\n4. Delete Event");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Event Name: ");
                String name = scanner.nextLine();
                System.out.print("Date: ");
                String date = scanner.nextLine();
                System.out.print("Location: ");
                String location = scanner.nextLine();
                controller.addEvent(new Event(name, date, location));
                break;
            case 2:
                List<Event> events = controller.getEvents();
                events.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Event Name to Update: ");
                String oldName = scanner.nextLine();
                System.out.print("New Event Name: ");
                String newName = scanner.nextLine();
                System.out.print("New Date: ");
                String newDate = scanner.nextLine();
                System.out.print("New Location: ");
                String newLocation = scanner.nextLine();
                controller.updateEvent(oldName, new Event(newName, newDate, newLocation));
                break;
            case 4:
                System.out.print("Event Name to Delete: ");
                String deleteName = scanner.nextLine();
                controller.deleteEvent(deleteName);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
