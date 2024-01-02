import org.junit.jupiter.api.Test;
import org.task.Constants.PassengerType;
import org.task.Passenger;
import org.task.TravelPackage;
import org.task.Destination;

import static org.junit.jupiter.api.Assertions.*;
public class TravelPackageTest {
    @Test
    void addDestination() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Test Destination");

        travelPackage.addDestination(destination);

        assertTrue(travelPackage.getDestinations().contains(destination));
    }

    @Test
    void addPassenger() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD,500);

        travelPackage.addPassenger(passenger);

        assertTrue(travelPackage.getPassengers().contains(passenger));
    }
}

