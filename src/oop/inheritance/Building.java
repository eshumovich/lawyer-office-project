package oop.inheritance;

import oop.Address;

import java.util.Objects;

public class Building<A> implements Openable {

    private Address address;
    private A access;

    public Building(Address address) {
        this.address = address;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public String toString() {
        return "Building{" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(address, building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public A getAccess() {
        return access;
    }

    public void setAccess(A access) {
        this.access = access;
    }
}
