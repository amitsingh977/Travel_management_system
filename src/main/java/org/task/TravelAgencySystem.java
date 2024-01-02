package org.task;

import org.task.Constants.PassengerType;

public class TravelAgencySystem {
    public static void main(String[] args) {


        TravelPackage uttarPradeshPackage = new TravelPackage("Taj Mahal", 50);

        Destination agra = new Destination("Agra");
        Activity tajMahalVisit = new Activity("Taj Mahal Visit", "Explore Taj Mahal", 50.0, 100, agra);
        agra.addActivity(tajMahalVisit);

        Destination mathura = new Destination("Mathura");
        Activity temple = new Activity("Temple Tour", "Explore Mathura", 40.0, 80, mathura);
        mathura.addActivity(temple);

        uttarPradeshPackage.addDestination(agra);
        uttarPradeshPackage.addDestination(mathura);

        Passenger standardPassenger = new Passenger("Amit Singh", 1, PassengerType.STANDARD,500);
        Passenger goldPassenger = new Passenger("Ankit Sharma", 2, PassengerType.GOLD,500);
        Passenger premiumPassenger = new Passenger("Ram", 3, PassengerType.PREMIUM,0);

        uttarPradeshPackage.addPassenger(standardPassenger);
        uttarPradeshPackage.addPassenger(goldPassenger);
        uttarPradeshPackage.addPassenger(premiumPassenger);

        tajMahalVisit.enrollPassenger(standardPassenger);
        temple.enrollPassenger(goldPassenger);

        uttarPradeshPackage.printItinerary();
        uttarPradeshPackage.printPassengerList();
        uttarPradeshPackage.printPassengerDetails(standardPassenger);
        uttarPradeshPackage.printAvailableActivities();

    }
}
