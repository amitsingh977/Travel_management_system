import org.junit.jupiter.api.Test;
import org.task.Activity;
import org.task.Destination;
import org.task.Passenger;

import static org.junit.jupiter.api.Assertions.*;
import static org.task.Constants.PassengerType.GOLD;
import static org.task.Constants.PassengerType.STANDARD;
import org.junit.jupiter.api.BeforeEach;


public class ActivityTest{

    private Destination destination;
    private Activity activity;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        destination = new Destination("TestDestination");
        activity = new Activity("TestActivity", "TestDescription", 50.0, 3, destination);
        passenger = new Passenger("TestPassenger", 123, STANDARD,500);
    }

    @Test
    void testEnrollPassenger() {
        activity.enrollPassenger(passenger);

        assertTrue(activity.getCapacity() == 2);
        assertTrue(passenger.getEnrolledActivities().contains(activity));
    }

    @Test
    void testIsFull() {
        assertFalse(activity.isFull());

        for (int i = 0; i < 3; i++) {
            Passenger newPassenger = new Passenger("Passenger" + i, 100 + i, STANDARD,500);
            activity.enrollPassenger(newPassenger);
        }

        assertTrue(activity.isFull());
    }
}
