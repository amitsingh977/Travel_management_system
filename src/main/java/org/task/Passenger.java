package org.task;

import org.task.Constants.PassengerType;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType passengerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }

    public void setEnrolledActivities(List<Activity> enrolledActivities) {
        this.enrolledActivities = enrolledActivities;
    }

    private List<Activity> enrolledActivities;

    public Passenger(String name, int passengerNumber, PassengerType passengerType,double balance ) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.enrolledActivities = new ArrayList<>();
        switch (passengerType) {
            case STANDARD:
                this.balance = balance;
                break;
            case GOLD:
                this.balance = balance;
                break;
            case PREMIUM:
                this.balance = 0.0;
                break;
        }

    }

    public void addEnrolledActivity(Activity activity) {
        enrolledActivities.add(activity);
    }
    public void enrollForActivity(Activity activity) {
        if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
            double activityCost = activity.getCost();
            if (passengerType == PassengerType.GOLD) {
                double discountAmount = 0.1 * activityCost;
                activityCost -= discountAmount;
                this.balance -= discountAmount;
            }


            if (this.balance >= activityCost) {
                activity.enrollPassenger(this);
                this.balance -= activityCost;
                addEnrolledActivity(activity);
            } else {
                System.out.println("Insufficient balance to enroll for the activity.");
            }
        } else if (passengerType == PassengerType.PREMIUM) {
            activity.enrollPassenger(this);
            addEnrolledActivity(activity);
        }
    }

}
