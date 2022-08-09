package oop.characteristic;

import oop.Address;
import oop.inheritance.Available;
import oop.inheritance.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Lawyer extends Human implements Available {

    private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);

    private static int quantityLawyers;

    private Address address;
    private LocalDate birth;
    private int rating;
    private BigDecimal salary;

    public Lawyer(String name, Address address, LocalDate birth) {
        super(name);
        this.address = address;
        this.birth = birth;
        quantityLawyers++;
    }

    @Override
    public void enterUniversity() {
        System.out.println(getName() + " entered the Harvard University");
    }

    public void provideDefendence(Client client) {
        LOGGER.info(getName() + " provides defendence to a " + client.getName());
        client.payLawyer(getSalary());
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "address=" + address +
                ", birth=" + birth +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawyer lawyer = (Lawyer) o;
        return rating == lawyer.rating && Objects.equals(address, lawyer.address) && Objects.equals(birth, lawyer.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, birth, rating);
    }

    public static int getQuantityLawyers() {
        return quantityLawyers;
    }

    public static void setQuantityLawyers(int quantityLawyers) {
        Lawyer.quantityLawyers = quantityLawyers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

