package oop;

import java.util.Objects;

public class Address {

    private String country;
    private String city;
    private Integer houseNumber;

    public Address(String country, String city, Integer houseNumber) {
        this.country = country;
        this.city = city;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(houseNumber, address.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, houseNumber);
    }
}
