package org.task;

import java.util.ArrayList;
import java.util.List;

import static org.task.Constants.PassengerType.GOLD;
import static org.task.Constants.PassengerType.PREMIUM;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for " + name + " package:");
        System.out.println("  Passenger Capacity: " + passengerCapacity);
        System.out.println("  Number of Passengers Enrolled: " + passengers.size());

        for (Passenger passenger : passengers) {
            System.out.println("    - Passenger Name: " + passenger.getName());
            System.out.println("      Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Details for Passenger " + passenger.getName() + " (Number: " + passenger.getPassengerNumber() + "):");

        System.out.println("  Passenger Name: " + passenger.getName());
        System.out.println("  Passenger Number: " + passenger.getPassengerNumber());


        if (passenger.getPassengerType() != PREMIUM) {
            System.out.println("  Balance: $" + passenger.getBalance());
        }

        List<Activity> enrolledActivities = passenger.getEnrolledActivities();
        if (!enrolledActivities.isEmpty()) {
            System.out.println("  Enrolled Activities:");
            for (Activity activity : enrolledActivities) {
                System.out.println("    - Activity: " + activity.getName());
                System.out.println("      Destination: " + activity.getDestination().getName());
                System.out.println("      Price Paid: $" + (passenger.getPassengerType() == GOLD ?
                        (activity.getCost() - (0.1 * activity.getCost())) : activity.getCost()));
            }
        } else {
            System.out.println("  No activities enrolled.");
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities for " + name + " package:");

        for (Destination destination : destinations) {
            System.out.println("  Destination: " + destination.getName());

            for (Activity activity : destination.getActivities()) {
                if (!activity.isFull()) {
                    int availableSpaces = activity.getCapacity();
                    System.out.println("    - Activity: " + activity.getName());
                    System.out.println("      Available Spaces: " + availableSpaces);
                }
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Destinations:");

        for (Destination destination : destinations) {
            System.out.println("  - " + destination.getName());

            for (Activity activity : destination.getActivities()) {
                System.out.println("    - Activity: " + activity.getName());
                System.out.println("      Cost: $" + activity.getCost());
                System.out.println("      Capacity: " + activity.getCapacity());
                System.out.println("      Description: " + activity.getDescription());
            }
        }
    }

}

