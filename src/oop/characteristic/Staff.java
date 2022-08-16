package oop.characteristic;

import oop.exception.InvalidLawyersQuantity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class Staff {

    private static final Logger LOGGER = LogManager.getLogger(Staff.class);

    private List<Lawyer> lawyers;

    public Staff(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public void showAllLawyers(List<Lawyer> lawyers) {
        for (Lawyer lawyer : lawyers) {
            LOGGER.info(lawyer.getName() + " has rating " + lawyer.getRating() + "; ");
        }
        if (lawyers.size() == 0) {
            throw new InvalidLawyersQuantity("The number of lawyers is to low");
        }
    }

    public void allLawyersBirthdays(List<Lawyer> lawyers) {
        for (int i = 0; i < lawyers.size(); i++) {
            LOGGER.info(lawyers.get(i).getName() + " was born " + lawyers.get(i).getBirth());
        }
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "lawyers=" + lawyers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(lawyers, staff.lawyers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lawyers);
    }
}
