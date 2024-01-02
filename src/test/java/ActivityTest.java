import org.junit.jupiter.api.Test;
import org.task.Activity;
import org.task.Destination;
import org.task.Passenger;

import static org.junit.jupiter.api.Assertions.*;
import static org.task.Constants.PassengerType.GOLD;
import static org.task.Constants.PassengerType.STANDARD;

public class ActivityTest{

    @Test
    public void testEnrollPassenger() {
        Destination destination = new Destination("City A");
        Activity activity = new Activity("Hiking", "Nature Walk", 20.0, 2, destination);

        Passenger passenger1 = new Passenger("Amit",1,GOLD,500);
        Passenger passenger2 = new Passenger("Bob",2,STANDARD,500);

        activity.enrollPassenger(passenger1);
        activity.enrollPassenger(passenger2);

        assertEquals(2, activity.getCapacity());
        assertTrue(passenger1.getEnrolledActivities().contains(activity));
        assertTrue(passenger2.getEnrolledActivities().contains(activity));
    }

    @Test
    public void testIsFull() {
        Destination destination = new Destination("City B");

        Activity activity = new Activity("Sightseeing", "City Tour", 30.0, 1, destination);

        assertFalse(activity.isFull());
        Passenger passenger = new Passenger("Amit",1,GOLD,500);
        activity.enrollPassenger(passenger);

        assertTrue(activity.isFull());
    }

}
