package oop.characteristic;

import oop.inheritance.Work;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class ClientCase extends Work {

    private static final Logger LOGGER = LogManager.getLogger(ClientCase.class);

    private String description;

    public ClientCase(String severity, BigDecimal price, String description) {
        super(severity, price);
        this.description = description;
    }

    @Override
    public void provideWork() {
        LOGGER.info("Resolving of client case costs: " + getPrice());
    }

    public void caseWaiting(LocalDate prevDate) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(prevDate, now);

        LOGGER.info("Event waiting for: years: " + period.getYears() + " , months: " + period.getMonths() + ", days: " + period.getDays());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Case{" +
                "event ='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCase that = (ClientCase) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
