package oop.inheritance;

import oop.Address;

import java.time.LocalDate;

public class CompetitorOrganization extends Organization {

    private Address address;

    public CompetitorOrganization(String name, LocalDate dateOfFoundation, Address address) {
        super(name, dateOfFoundation);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address.toString() + " " + super.toString();
    }
}
