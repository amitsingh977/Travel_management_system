import org.junit.jupiter.api.Test;
import org.task.Activity;
import org.task.Destination;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DestinationTest {


    @Test
    void addActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10, destination);

        destination.addActivity(activity);

        assertTrue(destination.getActivities().contains(activity));
    }

    @Test
    void addEnrolledActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10, destination);

        //destination.addEnrolledActivity(activity);

        // Add assertions based on the expected behavior
    }


}
