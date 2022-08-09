package oop.inheritance;

import oop.Address;
import oop.characteristic.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class CompetitorLawyersOffice extends CompetitorOrganization implements Printable{

    private static final Logger LOGGER = LogManager.getLogger(CompetitorLawyersOffice.class);

    public CompetitorLawyersOffice(String name, LocalDate dateOfFoundation, Address address) {
        super(name, dateOfFoundation, address);
    }

    public void stealInformation() {
        LOGGER.info("Competitor lawyer office trying to steal information about the clients");
    }

    @Override
    public void print() {
        LOGGER.info(getName() + " is founded in " + getDateOfFoundation() + "\n");
    }

    @Override
    public void read() {
        LOGGER.info("Read info");
    }

    @Override
    public String toString() {
        return "CompetitorLawyersOffice{}" + super.toString();
    }


}
