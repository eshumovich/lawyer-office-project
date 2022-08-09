package oop.characteristic;

import oop.exception.InvalidLawyersQuantity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Staff {

    private static final Logger LOGGER = LogManager.getLogger(Staff.class);

    private Lawyer[] lawyers;

    public Staff(Lawyer[] lawyers) {
        this.lawyers = lawyers;
    }

    public void showAllLawyers(Lawyer[] lawyers) {
        for (Lawyer lawyer : lawyers) {
            LOGGER.info(lawyer.getName() + " has rating " + lawyer.getRating() + "; ");
        }
        if (lawyers.length == 0) {
            throw new InvalidLawyersQuantity("The number of lawyers is to low");
        }
    }

    public void allLawyersBirthdays(Lawyer[] lawyers) {
        for (int i = 0; i < lawyers.length; i++) {
            LOGGER.info(lawyers[i].getName() + " was born " + lawyers[i].getBirth());
        }
    }

    public Lawyer[] getLawyer() {
        return lawyers;
    }

    public void setLawyer(Lawyer[] lawyers) {
        this.lawyers = lawyers;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "lawyers=" + Arrays.toString(lawyers) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Arrays.equals(lawyers, staff.lawyers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lawyers);
    }
}
