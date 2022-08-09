package oop.inheritance;

import oop.characteristic.Staff;
import oop.exception.InvalidDateException;
import oop.exception.NameInvalidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Organization {

    private static final Logger LOGGER = LogManager.getLogger(Organization.class);

    private String name;
    private LocalDate dateOfFoundation;

    public Organization(String name, LocalDate dateOfFoundation) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
    }

    public void issueLicense() {
        LOGGER.info(name + "issue a license");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameInvalidException {
        if (name.contains(".")) {
            throw new NameInvalidException("This name is wrong");
        }
        this.name = name;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        int years = LocalDate.now().getYear() - dateOfFoundation.getYear();
        if(years < 0) {
            throw new InvalidDateException("Date of company foundation is incorrect");
        }
        this.dateOfFoundation = dateOfFoundation;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", dateOfFoundation=" + dateOfFoundation +
                '}';
    }
}
