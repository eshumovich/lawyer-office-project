package oop.inheritance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbonementHour implements AccessableHour{

    private static final Logger LOGGER = LogManager.getLogger(CompetitorLawyersOffice.class);

    @Override
    public void getAccess() {
        LOGGER.info("You have got an access to the building for 1 hour");
    }
}
