import org.junit.jupiter.api.Test;
import org.task.Activity;
import org.task.Constants.PassengerType;
import org.task.Destination;
import org.task.Passenger;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PassengerTest {

    @Test
    void addEnrolledActivity() {
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD,500);
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10, new Destination("Test Destination"));

        passenger.addEnrolledActivity(activity);

        assertTrue(passenger.getEnrolledActivities().contains(activity));
    }
}
