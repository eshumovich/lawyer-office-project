package oop.characteristic;

import oop.Address;
import oop.inheritance.AccessableFullDay;
import oop.inheritance.Bookable;
import oop.inheritance.Building;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class CourtHouse<A extends AccessableFullDay> extends Building<A> implements Bookable {

    private static final Logger LOGGER = LogManager.getLogger(CourtHouse.class);

    public CourtHouse(Address address) {
        super(address);
    }

    public void bookCourtHouse(LocalDateTime dateTime) {
        LOGGER.info("CourtHouse is booked on: " + dateTime);
    }

    @Override
    public void startTrial() {
        LOGGER.info("Trial is started");
    }

    @Override
    public String toString() {
        return "CourtHouse{}";
    }
}
